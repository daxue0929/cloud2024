package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：daxue0929
 * @Date：2024/3/14 15:09
 */
@RestController
@Slf4j
public class PayAlibabaController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id) {
        String result =  "nacos registry, serverPort: "+ serverPort+"\t id"+id;
        log.info("进来了一个调用: {}", result);
        return result;
    }
}