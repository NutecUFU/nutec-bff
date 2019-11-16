package br.ufu.nutec.bff.repository.entity

import br.ufu.nutec.bff.repository.entity.enum.ExperimentStatus
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Experiment (
    @Id
    @GenericGenerator(
        name = "experiment_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "experiment_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experiment_id_seq")
    var id: BigInteger? = null,

    @NotNull
    var name: String? = null,

    var description: String? = null,

    @NotNull
    var url: String? = null,

    @Enumerated(EnumType.STRING)
    var status: ExperimentStatus? = null
)