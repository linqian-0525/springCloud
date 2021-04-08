package springbootredis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootredis.demo.service.RedisService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexCotroller {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/setString")
    public String setString(String key,String value){
        redisService.setString(key,value);
        return "success";
    }

    @RequestMapping("/setList")
    public String setList(String key,String value){
        List<String> stringList = new ArrayList<String>();
        stringList.add("123");
        stringList.add("456");
        stringList.add("789");
        redisService.setList(key,stringList);
        return "success";
    }
    @RequestMapping("/getKey")
    public String getKey(String key){
        return redisService.getStringKey(key);
    }
}
