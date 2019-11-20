package br.ufu.nutec.bff.web.util.jwt

import br.ufu.nutec.bff.repository.entity.Customer
import org.junit.Test

class JwtUtilTest{

    private val jwtUtil: JwtUtil = JwtUtil()

    @Test
    fun generateToken() {
        val customer = Customer(
            id = 1.toBigInteger(),
            password = "123456",
            username = "matheussn"
        )
        val token = jwtUtil.generateToken(customer)

        print(token)
    }
}
