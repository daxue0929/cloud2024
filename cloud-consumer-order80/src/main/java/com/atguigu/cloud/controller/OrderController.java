package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author：daxue0929
 * @Date：2024/3/6 13:27
 */
@RestController
public class OrderController {

//    public static final String Payment_URL = "http://localhost:8001";
    public static final String Payment_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/pay/add")
    public ResultData add(PayDTO payDTO) {
        ResultData resultData = restTemplate.postForObject(Payment_URL + "/pay/add", payDTO, ResultData.class);
        return resultData;
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(Payment_URL + "/pay/get/"+id, ResultData.class);
    }



}
