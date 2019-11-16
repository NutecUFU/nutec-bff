package br.ufu.nutec.bff.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
@ComponentScan(basePackages = ["br.ufu.nutec.bff.service"])
open class ServiceAutoConf {
    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)!!
    }

    @PostConstruct
    fun postConstruct() {
        logger.info("ServiceAutoConf executed")
    }
}