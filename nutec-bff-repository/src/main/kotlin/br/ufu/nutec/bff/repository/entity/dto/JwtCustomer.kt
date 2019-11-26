package br.ufu.nutec.bff.repository.entity.dto

import java.math.BigInteger

data class JwtCustomer (
    val id: BigInteger,
    val name: String,
    val email: String
)