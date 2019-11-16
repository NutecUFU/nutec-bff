package br.ufu.nutec.bff.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
data class CustomerInfo (
    @Id
    @GenericGenerator(
        name = "customer_info_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "customer_info_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_info_id_seq")
    var id: BigInteger? = null,

    @OneToOne(targetEntity = Customer::class, fetch = FetchType.LAZY)
    var customer: Customer? = null,

    @NotNull
    var name: String? = null,

    @NotNull
    @Email
    var email: String? = null,

    @NotNull
    var documentType: String? = null,

    @NotNull
    var documentValue: String? = null
)