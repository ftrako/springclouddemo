package com.example.demoapisrv.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "discoveryprovidersrv")
public interface  ProviderFeign {
    @GetMapping("/v1/discoveryprovidersrv/detail")
    String requestDetail(@RequestParam("id") String id);
}
