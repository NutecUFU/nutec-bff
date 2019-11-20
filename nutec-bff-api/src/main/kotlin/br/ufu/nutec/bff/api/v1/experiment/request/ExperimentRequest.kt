package br.ufu.nutec.bff.api.v1.experiment.request

import br.ufu.nutec.bff.repository.entity.enum.ExperimentStatus
import javax.validation.constraints.NotNull

data class ExperimentRequest(
    @field:NotNull
    val name: String,
    val description: String? = null,
    @field:NotNull
    val url: String,
    @field:NotNull
    val status: ExperimentStatus
)