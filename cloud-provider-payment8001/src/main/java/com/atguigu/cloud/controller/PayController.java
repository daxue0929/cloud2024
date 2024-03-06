package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：daxue0929
 * @Date：2024/3/6 10:00
 */
@RestController
@Slf4j
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值: " + i;
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    @PutMapping(value = "/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.update(pay);
        return "成功修改记录，返回值: " + i;
    }

    @GetMapping(value = "/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id) {
        return payService.getById(id);
    }

    @GetMapping(value = "/pay/getAll")
    public List<Pay> getAll() {
        List<Pay> all = payService.getAll();
        return all;
    }
}
