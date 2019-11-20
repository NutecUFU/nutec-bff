package br.ufu.nutec.bff.service.v1.experiment.impl

import br.ufu.nutec.bff.api.exception.BadRequestException
import br.ufu.nutec.bff.api.exception.NotFoundException
import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import br.ufu.nutec.bff.repository.entity.Experiment
import br.ufu.nutec.bff.repository.entity.enum.ExperimentStatus
import br.ufu.nutec.bff.repository.repository.ExperimentRepository
import br.ufu.nutec.bff.service.v1.experiment.ExperimentService
import br.ufu.nutec.bff.service.v1.experiment.converter.toEntity
import br.ufu.nutec.bff.service.v1.experiment.converter.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class ExperimentServiceImpl (
    private val experimentRepository: ExperimentRepository
): ExperimentService {

    private val validExperimentStatus = listOf(ExperimentStatus.ACTIVE, ExperimentStatus.IN_CONSTRUCTION)

    override fun create(experiment: ExperimentRequest): ExperimentResponse {
        val experimentEntity = experiment.toEntity()

        existExperiment(experiment.name)

        return experimentRepository.save(experimentEntity).toResponse()
    }

    override fun delete(id: BigInteger) {
        existExperiment(id)
        return experimentRepository.deleteById(id)
    }

    override fun edit(id: BigInteger, experiment: ExperimentRequest): ExperimentResponse {
        val oldExperiment = existExperiment(id)
        val newExperiment = experiment.toEntity()

        if( oldExperiment.name != newExperiment.name){
            existExperiment(newExperiment.name.toString())
        }

        return experimentRepository.save(newExperiment.copy(id = id)).toResponse()
    }

    override fun list(): List<ExperimentResponse> {
        return experimentRepository.findAllByStatusIn(validExperimentStatus).toResponse()
    }

    override fun getOne(id: BigInteger): ExperimentResponse {
        return experimentRepository.findByIdOrNull(id)?.toResponse() ?: throw NotFoundException(
            "There is no experiment with id $id"
        )
    }

    private fun existExperiment(id: BigInteger): Experiment =
        experimentRepository.findByIdOrNull(id) ?: throw NotFoundException(
            "There is no experiment with id $id"
        )

    private fun existExperiment(name: String) {
        val experiment = experimentRepository.findByNameAndStatusIn(name, validExperimentStatus)

        if(experiment != null){
            throw BadRequestException("An experiment with this name already exists!")
        }
    }
}