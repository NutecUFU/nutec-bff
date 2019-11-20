package br.ufu.nutec.bff.api.v1.customer.response

import java.math.BigInteger

data class CustomerResponse (
    val id: BigInteger,
    val username: String
)