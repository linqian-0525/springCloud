package com.atguigu.springCloud.controller;


import com.atguigu.springCloud.entities.CommonResult;
import com.atguigu.springCloud.entities.Payment;
import com.atguigu.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentById(@PathVariable("id") Integer id){
        String  result = paymentService.paymentInfo_OK(id);
        return  result;
    }

    @GetMapping({"/payment/hystrix/timeout/{id}"})
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = this.paymentService.paymentInfo_TimeOut(id);
        log.info("******result：" + result);
        return result;
    }
}
