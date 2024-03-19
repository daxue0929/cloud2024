package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @Author：daxue0929
 * @Date：2024/3/18 16:12
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
