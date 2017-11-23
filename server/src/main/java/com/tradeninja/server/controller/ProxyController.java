package com.tradeninja.server.controller;

import com.tradeninja.server.config.ProxyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController("proxy")
public class ProxyController {

    private final ProxyConfiguration configuration;
    private final RestTemplate template;


    @Autowired
    public ProxyController(RestTemplate template, ProxyConfiguration configuration) {
        this.template = template;
        this.configuration = configuration;

    }

    @GetMapping
    public void proxy(HttpServletRequest request) {
        System.out.println("uri" + request.getRequestURI());
        System.out.println("url" + request.getRequestURL().toString());
    }

}
