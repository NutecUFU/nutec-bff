package br.ufu.nutec.bff.web.util.exception

import br.ufu.nutec.bff.api.exception.BadRequestException
import br.ufu.nutec.bff.api.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
open class ExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException::class)
    fun exceptionHandler(e: BadRequestException): Map<String, String> =
        mapOf("Error" to e.message.toString())

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun exceptionHandler(e: NotFoundException): Map<String, String> =
        mapOf("Error" to e.message.toString())

}