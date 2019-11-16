package br.ufu.nutec.bff.service.v1.customer

import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.api.v1.customer.response.CustomerResponse
import java.math.BigInteger

interface CustomerService {
    fun create(customer: CustomerRequest): CustomerResponse
    fun delete(id: BigInteger)
    fun edit(id: BigInteger, customer:CustomerRequest): CustomerResponse
    fun list(): List<CustomerResponse>
    fun getOne(id: BigInteger): CustomerResponse
}