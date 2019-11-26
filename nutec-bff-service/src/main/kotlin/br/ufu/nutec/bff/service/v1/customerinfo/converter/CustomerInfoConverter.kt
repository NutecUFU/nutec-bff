package br.ufu.nutec.bff.service.v1.customerinfo.converter

import br.ufu.nutec.bff.repository.entity.CustomerInfo
import br.ufu.nutec.bff.repository.entity.dto.JwtCustomer

fun CustomerInfo.toJwt(username: String?): JwtCustomer = JwtCustomer(
    id = id!!,
    name = username!!,
    email = email!!
)