package com.tradeninja.backend.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "tradeninja.proxy")
class ProxyConfig(var hosts: List<String>? = null)