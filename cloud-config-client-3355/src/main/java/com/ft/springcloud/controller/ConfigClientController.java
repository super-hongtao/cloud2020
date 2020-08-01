package com.ft.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : HongTao
 * @version : v1.0
 * @description TODO
 * @date : 2020/8/1 23:03
 */
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;  //要访问的3344上的信息

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
