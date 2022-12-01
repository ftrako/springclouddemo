package com.example.demoapisrv.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页
 *
 * @author cdj
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
@RequestMapping("/v1/gw")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("")
    public String index() {
        return "ok";
    }
}
