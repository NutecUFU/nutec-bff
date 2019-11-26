package br.ufu.nutec.bff.web.config

import br.ufu.nutec.bff.api.exception.UnauthorizedException
import br.ufu.nutec.bff.web.util.jwt.JwtUtil
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.HandlerExceptionResolver
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(
    private val jwtUtil: JwtUtil,
    private val customUserDetails: CustomUserDetails,
    private val securityUtil: SecurityUtil,
    @Qualifier("handlerExceptionResolver")
    private val handlerExceptionResolver:   HandlerExceptionResolver
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorization = request.getHeader("Authorization")

        val username: String?
        val token: String?

        if (authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7)
            try {
                username = jwtUtil.extractUsername(token)
            } catch (e: UnauthorizedException) {
                handlerExceptionResolver.resolveException(
                    request,
                    response,
                    null,
                    UnauthorizedException(e.message.toString()))
                return
            }
        } else {
            username = null
            token = null
        }

        if (username != null && token != null && SecurityContextHolder.getContext().authentication == null) {

            val userDetails = customUserDetails.loadUserByUsername(username)

            if (jwtUtil.validateToken(token, userDetails!!)) {
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities)
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }
        chain.doFilter(request, response)
    }
}