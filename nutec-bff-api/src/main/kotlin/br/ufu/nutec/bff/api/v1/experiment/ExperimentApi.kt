package br.ufu.nutec.bff.api.v1.experiment

import br.ufu.nutec.bff.api.v1.experiment.request.ExperimentRequest
import br.ufu.nutec.bff.api.v1.experiment.response.ExperimentResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigInteger
import javax.validation.Valid

@RequestMapping("/v1/experiments")
interface ExperimentApi {
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun list(): List<ExperimentResponse>

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getOneExperiment(
        @PathVariable(name = "id") id: BigInteger
    ): ExperimentResponse

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody experiment: ExperimentRequest
    ): ExperimentResponse

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun edit(
        @PathVariable(name = "id") id: BigInteger,
        @Valid @RequestBody experiment: ExperimentRequest
    ): ExperimentResponse

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable(name = "id") id: BigInteger
    )
}