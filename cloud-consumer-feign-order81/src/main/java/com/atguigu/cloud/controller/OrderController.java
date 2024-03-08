package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：daxue0929
 * @Date：2024/3/6 13:27
 */
@RestController
public class OrderController {

    /**
     * openFeign
     * 超时控制
     * 支持sentinel的fallback
     * 支持http请求和响应的压缩
     */

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return payFeignApi.getPayInfo(id);
    }
}
