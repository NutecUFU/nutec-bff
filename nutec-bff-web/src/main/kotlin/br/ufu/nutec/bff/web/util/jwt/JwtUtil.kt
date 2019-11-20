package br.ufu.nutec.bff.web.util.jwt

import br.ufu.nutec.bff.repository.entity.Customer
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {

    private val SECRET_KEY = "nutec-bff"

    fun generateToken(customer: Customer): String {
        val claims = HashMap<String, Any>()
        return createToken(claims, customer.username)
    }

    private fun createToken(claims: Map<String, Any>, subject: String?): String {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact()
    }
}