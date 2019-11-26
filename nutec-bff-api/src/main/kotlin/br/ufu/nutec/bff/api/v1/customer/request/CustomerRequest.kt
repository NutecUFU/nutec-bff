package br.ufu.nutec.bff.api.v1.customer.request

import javax.validation.constraints.NotNull

data class CustomerRequest (
    var username: String? = null,
    var password: String? = null
)