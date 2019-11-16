package br.ufu.nutec.bff.web.interceptor

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthenticatedInterceptor: HandlerInterceptor {
    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)!!
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        logger.info("PRE HANDLE")
        return super.preHandle(request, response, handler)
    }
}