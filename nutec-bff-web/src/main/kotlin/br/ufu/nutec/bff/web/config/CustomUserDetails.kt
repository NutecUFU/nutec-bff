package br.ufu.nutec.bff.web.config

import br.ufu.nutec.bff.repository.entity.Customer
import br.ufu.nutec.bff.service.v1.customer.CustomerService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetails(
    private val customerService: CustomerService
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails? {
        return customerService.getByUserName(username)?.toUser()
    }
}

fun Customer.toUser(): User = User(
    username,
    password,
    roles?.map { SimpleGrantedAuthority(it.name) }
)