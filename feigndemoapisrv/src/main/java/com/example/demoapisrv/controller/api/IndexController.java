package com.example.demoapisrv.controller.api;

import com.example.demoapisrv.feign.ProviderFeign;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 主页
 *
 * @author cdj
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
@RequestMapping("/v1/feigndemo")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private ProviderFeign providerFeign;

    @GetMapping("")
    public String index() {
        return "ok";
    }

    @GetMapping("/feign")
    public String testFeign(@RequestParam("id") String id) {
        logger.debug("id:"+id);
        return providerFeign.requestDetail(id);
    }
}
