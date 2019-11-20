package br.ufu.nutec.bff.web.v1.authenticate

import br.ufu.nutec.bff.api.exception.BadRequestException
import br.ufu.nutec.bff.api.v1.authenticate.AuthenticateApi
import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.repository.entity.Customer
import br.ufu.nutec.bff.service.v1.customer.CustomerService
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticateController(
    private val customerService: CustomerService
): AuthenticateApi {
    override fun login(customerRequest: CustomerRequest) {
        val customer = authenticated(customerRequest)
    }

    private fun authenticated(customerRequest: CustomerRequest): Customer? {
        val customer = customerService.getByUserName(customerRequest.username.toString())

        if(customer?.password != customerRequest.password)
            throw BadRequestException("User Not Exists!")

        return customer
    }
}