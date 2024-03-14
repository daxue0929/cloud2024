package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author：daxue0929
 * @Date：2024/3/14 19:51
 */
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common() {
        System.out.println("FlowLimitService common come in...");
    }
}
