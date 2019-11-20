package br.ufu.nutec.bff.service.v1.experiment.converter

import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import br.ufu.nutec.bff.repository.entity.Experiment

fun Experiment.toResponse(): ExperimentResponse = ExperimentResponse(
    id = id!!,
    name = name!!,
    description = description ?: "",
    status = status!!,
    url = url!!
)

fun List<Experiment>.toResponse(): List<ExperimentResponse> = this.map { it.toResponse() }

fun ExperimentRequest.toEntity(): Experiment = Experiment(
    name = name,
    url = url,
    status = status,
    description = description
)