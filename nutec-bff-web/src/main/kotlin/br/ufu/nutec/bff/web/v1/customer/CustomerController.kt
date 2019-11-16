package br.ufu.nutec.bff.web.v1.customer

import br.ufu.nutec.bff.api.v1.customer.CustomerApi
import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.api.v1.customer.response.CustomerResponse
import br.ufu.nutec.bff.service.v1.customer.CustomerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import javax.validation.Valid

@RestController
class CustomerController(
    private val customerService: CustomerService
): CustomerApi {

    override fun listCustomers(): List<CustomerResponse> {
        return customerService.list()
    }

    override fun getOneCustomer(
        @PathVariable("id") id: BigInteger
    ): CustomerResponse {
        return customerService.getOne(id)
    }

    override fun create(
        @Valid @RequestBody customer: CustomerRequest
    ): CustomerResponse {
        return customerService.create(customer)
    }

    override fun edit(
        @PathVariable("id") id: BigInteger,
        @Valid @RequestBody customer: CustomerRequest
    ): CustomerResponse {
        return customerService.edit(id, customer)
    }

    override fun delete(
        @PathVariable("id") id: BigInteger
    ) {
        return customerService.delete(id)
    }

}