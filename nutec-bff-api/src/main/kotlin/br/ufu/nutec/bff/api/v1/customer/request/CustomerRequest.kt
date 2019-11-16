package br.ufu.nutec.bff.api.v1.customer.request

import javax.validation.constraints.NotNull

data class CustomerRequest (
    @field:NotNull
    var username: String? = null,

    @field:NotNull
    var password: String? = null
)