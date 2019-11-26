package br.ufu.nutec.bff.service.v1.customerinfo.impl

import br.ufu.nutec.bff.repository.entity.Customer
import br.ufu.nutec.bff.repository.entity.CustomerInfo
import br.ufu.nutec.bff.repository.repository.CustomerInfoRepository
import br.ufu.nutec.bff.service.v1.customerinfo.CustomerInfoService
import org.springframework.stereotype.Service

@Service
class CustomerInfoServiceImpl (
    private val customerInfoRepository: CustomerInfoRepository
): CustomerInfoService {
    override fun getByCustomer(customer: Customer): CustomerInfo {
        return customerInfoRepository.findByCustomer(customer)
    }

}