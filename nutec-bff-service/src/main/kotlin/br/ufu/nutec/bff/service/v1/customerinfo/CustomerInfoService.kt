package br.ufu.nutec.bff.service.v1.customerinfo

import br.ufu.nutec.bff.repository.entity.Customer
import br.ufu.nutec.bff.repository.entity.CustomerInfo

interface CustomerInfoService {
    fun getByCustomer(customer: Customer): CustomerInfo
}