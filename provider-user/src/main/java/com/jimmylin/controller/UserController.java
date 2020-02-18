package com.jimmylin.controller;

import com.jimmylin.springcloud.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return new User(id);
    }

    @GetMapping("/eureka-info")
    public String getEurekaInfo() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PRIVIDER-USER", false);
        return instance.getHomePageUrl();
    }
}
