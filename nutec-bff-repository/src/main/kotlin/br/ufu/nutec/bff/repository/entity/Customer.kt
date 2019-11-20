package br.ufu.nutec.bff.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Customer (

    @Id
    @GenericGenerator(
        name = "customer_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "customer_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    var id: BigInteger? = null,

    @NotNull
    var username: String? = null,

    @NotNull
    var password: String? = null,

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role::class)
    @JoinTable(
        name = "customer_roles",
        joinColumns = [JoinColumn(name = "customer_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: List<Role>? = null
)