package br.ufu.nutec.bff.service.v1.customerinfo.converter

import br.ufu.nutec.bff.repository.entity.CustomerInfo
import br.ufu.nutec.bff.repository.entity.Role
import br.ufu.nutec.bff.repository.entity.dto.JwtCustomer
import br.ufu.nutec.bff.service.v1.customerinfo.dto.RoleDto

fun CustomerInfo.toJwt(roles: List<Role>?): JwtCustomer = JwtCustomer(
    id = id!!,
    name = name!!,
    email = email!!,
    roles = roles!!
)

fun Role.toDto(): RoleDto = RoleDto(
    name = name!!
)

fun List<Role>.toJwt(): List<String?> = this.map {
    it.name
}