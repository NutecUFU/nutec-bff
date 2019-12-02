package br.ufu.nutec.bff.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Privilege (
    @Id
    @GenericGenerator(
        name = "privilege_id",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "privilege_id"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilege_id")
    var id: BigInteger? = null,

    @NotNull
    var name: String? = null//,

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "privileges")
//    var roles: List<Role>? = null
)