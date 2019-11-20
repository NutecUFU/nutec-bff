package br.ufu.nutec.bff.web.v1.experiment

import br.ufu.nutec.bff.api.v1.experiment.ExperimentApi
import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import br.ufu.nutec.bff.service.v1.experiment.ExperimentService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import javax.validation.Valid

@RestController
class ExperimentController(
    private val experimentService: ExperimentService
): ExperimentApi {
    override fun list(): List<ExperimentResponse> {
        return experimentService.list()
    }

    override fun getOneExperiment(
        @PathVariable(name = "id") id: BigInteger
    ): ExperimentResponse {
        return experimentService.getOne(id)
    }

    override fun create(
        @Valid @RequestBody experiment: ExperimentRequest
    ): ExperimentResponse {
        return experimentService.create(experiment)
    }

    override fun edit(
        @PathVariable(name = "id") id: BigInteger,
        @Valid @RequestBody experiment: ExperimentRequest
    ): ExperimentResponse {
        return experimentService.edit(id, experiment)
    }

    override fun delete(
        @PathVariable("id") id: BigInteger
    ) {
        return experimentService.delete(id)
    }
}