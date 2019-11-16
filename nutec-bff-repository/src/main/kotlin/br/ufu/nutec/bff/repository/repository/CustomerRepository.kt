package br.ufu.nutec.bff.repository.repository

import br.ufu.nutec.bff.repository.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface CustomerRepository: JpaRepository<Customer, BigInteger> {
    fun findFirstById(id: BigInteger): Customer?
    fun findByUsername(username: String): Customer?
}