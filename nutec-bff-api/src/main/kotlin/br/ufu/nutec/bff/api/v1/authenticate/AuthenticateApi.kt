package br.ufu.nutec.bff.api.v1.authenticate

import br.ufu.nutec.bff.api.v1.customer.request.CustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/v1/login")
interface AuthenticateApi {

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun login(
        @Valid @RequestBody customerRequest: CustomerRequest
    )


}