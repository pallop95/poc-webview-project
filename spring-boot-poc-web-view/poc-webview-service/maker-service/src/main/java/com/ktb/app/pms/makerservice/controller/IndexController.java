package com.ktb.app.pms.makerservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String index(){
        return appName;
    }

}
