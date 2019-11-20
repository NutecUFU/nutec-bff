package br.ufu.nutec.bff.api.v1.experiment.response

import br.ufu.nutec.bff.repository.entity.enum.ExperimentStatus
import java.math.BigInteger

data class ExperimentResponse (
    val id: BigInteger,
    val name: String,
    val description: String,
    val url: String,
    val status: ExperimentStatus
)