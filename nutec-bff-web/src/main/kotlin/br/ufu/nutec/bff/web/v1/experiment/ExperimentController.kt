package br.ufu.nutec.bff.web.v1.experiment

import br.ufu.nutec.bff.api.v1.experiment.ExperimentApi
import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import javax.validation.Valid

@RestController
class ExperimentController: ExperimentApi {
    override fun list(): List<ExperimentResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOneExperiment(
        @PathVariable(name = "id") id: BigInteger
    ): ExperimentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(
        @Valid @RequestBody experiment: ExperimentRequest
    ): ExperimentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun edit(
        @PathVariable(name = "id") id: BigInteger,
        @Valid @RequestBody experiment: ExperimentRequest
    ): ExperimentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(
        @PathVariable("id") id: BigInteger
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}