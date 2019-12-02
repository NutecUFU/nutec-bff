package br.ufu.nutec.bff.web.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
open class SecurityWebConfig(
    private val customerService: CustomUserDetails,
    private val jwtRequestFilter: JwtRequestFilter
): WebSecurityConfigurerAdapter() {

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService>(customerService)
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/v1/login").permitAll()
            .anyRequest().authenticated()
            .and().exceptionHandling()
            .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

}