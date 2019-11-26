package br.ufu.nutec.bff.api.exception

import java.lang.RuntimeException

class BadRequestException(
    msg: String
): RuntimeException(msg)

class NotFoundException(
    msg: String
): RuntimeException(msg)

class UnauthorizedException(
    msg: String
): RuntimeException(msg)