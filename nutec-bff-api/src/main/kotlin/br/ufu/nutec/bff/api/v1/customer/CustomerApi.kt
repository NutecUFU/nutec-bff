package br.ufu.nutec.bff.api.v1.customer

import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.api.v1.customer.response.CustomerResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigInteger
import javax.validation.Valid

@RequestMapping("/v1/customers")
interface CustomerApi {
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun listCustomers(): List<CustomerResponse>

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getOneCustomer(
            @PathVariable("id") id: BigInteger
    ): CustomerResponse

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody customer: CustomerRequest
    ): CustomerResponse

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun edit(
            @PathVariable("id") id: BigInteger,
            @Valid @RequestBody customer: CustomerRequest
    ): CustomerResponse

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
            @PathVariable("id") id: BigInteger
    )
}
