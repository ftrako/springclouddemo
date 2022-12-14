package com.example.demoapisrv.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主页
 *
 * @author cdj
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
@RequestMapping("/v1/discoveryconsumersrv")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("")
    public String index() {
        return "ok";
    }

    @GetMapping("/access")
    public String access() {
        // 选择第一个
        ServiceInstance instance = null;

        if (false) {
            // 获取服务 `demo-provider` 对应的实例列表
            List<ServiceInstance> instances = discoveryClient.getInstances("discoveryprovidersrv");
            instance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            instance = loadBalancerClient.choose("discoveryprovidersrv");
        }

        String targetUrl = instance.getUri() + "/v1/discoveryprovidersrv";
        logger.debug("target:" + targetUrl);
        String response = restTemplate.getForObject(targetUrl, String.class);
        return response;
    }
}
