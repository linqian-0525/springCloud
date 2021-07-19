package com.athuigu.springCloud.controller;

import com.athuigu.springCloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")   //设置全局fallback方法
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/hystrix/ok/{id}")
    public String getPaymentById(@PathVariable("id") Integer id){
        String  result = paymentHystrixService.paymentInfo_OK(id);
        return  result;
    }

    @HystrixCommand
    @GetMapping({"/consumer/hystrix/timeout/{id}"})
   /* @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i = 10/0;
        String result = this.paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("******result：" + result);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "消费者80，支付系统繁忙";
    }

    //全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试！";
    }
}
