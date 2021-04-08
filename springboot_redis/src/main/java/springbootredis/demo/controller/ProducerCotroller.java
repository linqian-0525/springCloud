package springbootredis.demo.controller;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootredis.demo.service.RedisService;

import javax.jms.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;


public class ProducerCotroller {

    public static void main(String[] args){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
    }
}
