package br.ufu.nutec.bff.service.v1.customer.impl

import br.ufu.nutec.bff.api.exception.BadRequestException
import br.ufu.nutec.bff.api.exception.NotFoundException
import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import br.ufu.nutec.bff.api.v1.customer.response.CustomerResponse
import br.ufu.nutec.bff.repository.entity.Customer
import br.ufu.nutec.bff.repository.repository.CustomerRepository
import br.ufu.nutec.bff.service.v1.customer.CustomerService
import br.ufu.nutec.bff.service.v1.customer.converter.toEntity
import br.ufu.nutec.bff.service.v1.customer.converter.toResponse
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository
): CustomerService {
    override fun delete(id: BigInteger) {
        existCustomer(id)
        customerRepository.deleteById(id)
    }

    override fun edit(id: BigInteger, customer: CustomerRequest): CustomerResponse {
        val oldCustomer = existCustomer(id)

        val newCustomer = customer.toEntity()

        if(oldCustomer.username != newCustomer.username) {
            existCustomer(newCustomer.username.toString())
        }

        return customerRepository.save(newCustomer.copy(id = id)).toResponse()
    }

    override fun list(): List<CustomerResponse> = customerRepository.findAll().toResponse()

    override fun getOne(id: BigInteger): CustomerResponse {
        val user = customerRepository.findById(id)
        if(!user.isPresent) throw NotFoundException("There is no customer with id $id")

        return user.get().toResponse()
    }

    override fun create(customer: CustomerRequest): CustomerResponse {
        val userEntity = customer.toEntity()

        existCustomer(userEntity.username.toString())

        return customerRepository.save(userEntity).toResponse()
    }

    private fun existCustomer(id: BigInteger): Customer =
        customerRepository.findFirstById(id) ?: throw NotFoundException(
            "There is no customer with id $id"
        )

    private fun existCustomer(userName: String) {
        val user = customerRepository.findByUsername(userName)

        if(user != null) {
            throw BadRequestException("Username Already Exists!")
        }
    }
}