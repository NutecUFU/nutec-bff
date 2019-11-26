package br.ufu.nutec.bff.web.util.jwt

import br.ufu.nutec.bff.repository.entity.Customer
import br.ufu.nutec.bff.repository.entity.dto.JwtCustomer
import org.junit.Test

class JwtUtilTest{

    private val jwtUtil: JwtUtil = JwtUtil()

    @Test
    fun generateToken() {
        val customer = JwtCustomer(
            id = 1.toBigInteger(),
            email = "123456",
            name = "matheussn"
        )
        val token = jwtUtil.generateToken(customer)

        print(token)
    }
}
