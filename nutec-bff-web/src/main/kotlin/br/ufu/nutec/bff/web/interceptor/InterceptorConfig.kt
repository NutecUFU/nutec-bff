package br.ufu.nutec.bff.web.interceptor

import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Component
class InterceptorConfig(
    private val authenticatedInterceptor: AuthenticatedInterceptor
): WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authenticatedInterceptor)
    }
}