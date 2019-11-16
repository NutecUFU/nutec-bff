package br.ufu.nutec.bff.service.v1.experiment.impl

import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import br.ufu.nutec.bff.repository.repository.ExperimentRepository
import br.ufu.nutec.bff.service.v1.experiment.ExperimentService
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class ExperimentServiceImpl (
    val experimentRepository: ExperimentRepository
): ExperimentService {
    override fun create(experiment: ExperimentRequest): ExperimentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: BigInteger) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun edit(id: BigInteger, experiment: ExperimentRequest): ExperimentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<ExperimentResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOne(id: BigInteger): ExperimentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}