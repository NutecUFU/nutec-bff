package br.ufu.nutec.bff.repository.repository

import br.ufu.nutec.bff.repository.entity.Experiment
import br.ufu.nutec.bff.repository.entity.enum.ExperimentStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ExperimentRepository: JpaRepository<Experiment, BigInteger> {
    fun findAllByStatusIn(status: List<ExperimentStatus>): List<Experiment>
    fun findByNameAndStatusIn(name: String, status: List<ExperimentStatus>): Experiment?
}