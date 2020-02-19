package com.jimmylin.springcloud.controller;

import com.jimmylin.springcloud.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/order/{id}")
    @HystrixCommand(fallbackMethod = "doFailed")
    public User getOrder(@PathVariable int id) {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PRIVIDER-USER", false);
        String url = instance.getHomePageUrl();

        User user = restTemplate.getForObject(url + "/user/" + id, User.class);
        return user;
    }

    public User doFailed(int id) {
        User user = new User(-100);
        return user;
    }


}

