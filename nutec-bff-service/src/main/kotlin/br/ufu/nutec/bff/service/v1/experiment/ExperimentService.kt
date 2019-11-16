package br.ufu.nutec.bff.service.v1.experiment

import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import java.math.BigInteger

interface ExperimentService {
    fun create(experiment: ExperimentRequest): ExperimentResponse

    fun delete(id: BigInteger)

    fun edit(id: BigInteger, experiment: ExperimentRequest): ExperimentResponse

    fun list(): List<ExperimentResponse>

    fun getOne(id: BigInteger): ExperimentResponse
}