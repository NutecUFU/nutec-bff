package br.ufu.nutec.bff.web.util.jwt

import br.ufu.nutec.bff.api.exception.UnauthorizedException
import br.ufu.nutec.bff.repository.entity.dto.JwtCustomer
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class JwtUtil {

    @Value("#{'\${jwt.secret}'}")
    lateinit var SECRET_KEY: String

    fun extractUsername(token: String): String {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body["name"].toString()
        } catch (e: Exception) {
            throw UnauthorizedException(e.message.toString())
        }
    }

    private fun extractExpiration(token: String): Date {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body.expiration
        } catch (e: Exception) {
            throw UnauthorizedException(e.message.toString())
        }
    }

    fun generateToken(jwtCustomer: JwtCustomer): String {
        val claims = HashMap<String, Any>()
        claims["name"] = jwtCustomer.name
        claims["email"] = jwtCustomer.email
        return createToken(claims, jwtCustomer.id.toString())
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    private fun createToken(claims: Map<String, Any>, subject: String): String {

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date.from(Instant.now().plusSeconds(140)))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact()
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return username == userDetails.username && !isTokenExpired(token)
    }
}