package br.ufu.nutec.bff.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class CustomerSocialNetwork (
    @Id
    @GenericGenerator(
        name = "customer_social_network_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "customer_social_network_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_social_network_id_seq")
    var id: BigInteger? = null,

    @NotNull
    @ManyToOne(targetEntity = CustomerInfo::class, fetch = FetchType.LAZY)
    var customerInfo: CustomerInfo? = null,

    @NotNull
    var name: String? = null,

    @NotNull
    var url: String? = null
)