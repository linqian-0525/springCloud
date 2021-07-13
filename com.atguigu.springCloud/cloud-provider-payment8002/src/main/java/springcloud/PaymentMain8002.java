package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
public class PaymentMain8002 {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
