package com.example.nacosdemoapisrv.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 主页
 *
 * @author cdj
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
@RefreshScope
@RequestMapping("/v1/nacosdemo")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${user.nickname:}")
    private String nickname;

    @GetMapping("")
    public String index() {
        return "ok";
    }

    @GetMapping("/nickname")
    public String nickname() {
        return nickname;
    }
}
