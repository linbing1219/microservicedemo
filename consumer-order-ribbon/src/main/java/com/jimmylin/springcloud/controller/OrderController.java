package com.jimmylin.springcloud.controller;

import com.jimmylin.springcloud.feign.IFeignClient;
import com.jimmylin.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private IFeignClient feignClient;

    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable int id) {

        User user = restTemplate.getForObject("http://PRIVIDER-USER/user/" + id, User.class);
        return user;
    }


    @GetMapping("/test")
    public String testLoadBalance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRIVIDER-USER");
        String result = String.format("serviceInstanceId: %s, serviceInstanceIP: %s, serviceInstancePort: %s",
                serviceInstance.getInstanceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return result;
    }

    @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable int id) {
        return feignClient.getUser(id);
    }
}

