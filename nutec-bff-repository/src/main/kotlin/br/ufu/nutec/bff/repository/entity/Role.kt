package br.ufu.nutec.bff.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Role (
    @Id
    @GenericGenerator(
        name = "role_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "role_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    var id: BigInteger? = null,

    @NotNull
    var name: String? = null,

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Privilege::class)
    @JoinTable(
        name = "roles_privileges",
        joinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "privilege_id", referencedColumnName = "id")]
    )
    var privileges: List<Privilege>? = null
)