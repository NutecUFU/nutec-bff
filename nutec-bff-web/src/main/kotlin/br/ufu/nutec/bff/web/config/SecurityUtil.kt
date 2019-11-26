package br.ufu.nutec.bff.web.config

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class SecurityUtil {

    fun validRoles(request: HttpServletRequest, token: String, userDetails: UserDetails) {
        val url = request.requestURL
        val method = request.method


    }
}