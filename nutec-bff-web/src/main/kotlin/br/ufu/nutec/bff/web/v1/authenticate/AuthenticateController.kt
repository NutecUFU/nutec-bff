package br.ufu.nutec.bff.web.v1.authenticate

import br.ufu.nutec.bff.api.exception.BadRequestException
import br.ufu.nutec.bff.api.exception.UnauthorizedException
import br.ufu.nutec.bff.api.v1.authenticate.AuthenticateApi
import br.ufu.nutec.bff.api.v1.authenticate.response.JwtToken
import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.repository.entity.dto.JwtCustomer
import br.ufu.nutec.bff.service.v1.customer.CustomerService
import br.ufu.nutec.bff.service.v1.customerinfo.CustomerInfoService
import br.ufu.nutec.bff.service.v1.customerinfo.converter.toJwt
import br.ufu.nutec.bff.web.util.jwt.JwtUtil
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticateController(
    private val customerService: CustomerService,
    private val customerInfoService: CustomerInfoService,
    private val jwtTokenUtil: JwtUtil
) : AuthenticateApi {

    override fun login(
        @RequestBody customerRequest: CustomerRequest
    ): JwtToken {
        val jwtCustomer = authenticated(customerRequest)
        val token = jwtTokenUtil.generateToken(jwtCustomer)

        return JwtToken(token)
    }

    private fun authenticated(customerRequest: CustomerRequest): JwtCustomer {
        val customer = customerService.getByUserName(customerRequest.username.toString())

        customer ?: throw BadRequestException("User Not Exists")

        if (customer.password != customerRequest.password)
            throw UnauthorizedException("Invalid Password")

        return customerInfoService.getByCustomer(customer).toJwt(customer.roles)
    }
}