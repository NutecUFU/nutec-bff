package br.ufu.nutec.bff.repository.repository

import br.ufu.nutec.bff.repository.entity.CustomerSocialNetwork
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface CustomerSocialNetworkRepository: JpaRepository<CustomerSocialNetwork, BigInteger>