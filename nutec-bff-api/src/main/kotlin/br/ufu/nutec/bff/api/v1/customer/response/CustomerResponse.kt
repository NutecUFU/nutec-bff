package br.ufu.nutec.bff.api.v1.customer.response

import java.math.BigInteger

data class CustomerResponse (
    var id: BigInteger? = null,
    var username: String? = null
)