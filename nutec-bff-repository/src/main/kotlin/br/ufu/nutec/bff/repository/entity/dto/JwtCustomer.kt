package br.ufu.nutec.bff.repository.entity.dto

import br.ufu.nutec.bff.repository.entity.Role
import java.math.BigInteger

data class JwtCustomer (
    val id: BigInteger,
    val name: String,
    val email: String,
    val roles: List<Role>
)