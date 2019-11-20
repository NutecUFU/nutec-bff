package br.ufu.nutec.bff.service.v1.customer.converter

import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.api.v1.customer.response.CustomerResponse
import br.ufu.nutec.bff.repository.entity.Customer

fun Customer.toResponse(): CustomerResponse = CustomerResponse(
    id = id!!,
    username = username!!
)

fun List<Customer>.toResponse(): List<CustomerResponse> = this.map { it.toResponse() }

fun CustomerRequest.toEntity(): Customer = Customer(
    username = username,
    password = password
)