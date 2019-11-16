package br.ufu.nutec.bff.config

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.annotation.PostConstruct

@Configuration
@EnableJpaRepositories("br.ufu.nutec.bff.repository")
@EntityScan("br.ufu.nutec.bff.repository")
@ComponentScan(basePackages = ["br.ufu.nutec.bff.repository"])
open class RepositoryAutoConf {
    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)!!
    }

    @PostConstruct
    fun postConstruct() {
        logger.info("RepositoryAutoConfig executed")
    }
}