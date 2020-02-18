package com.jimmylin.springcloud.feign;

import com.jimmylin.springcloud.config.FeignClientConfig;
import com.jimmylin.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "privider-user", configuration = FeignClientConfig.class)
public interface IFeignClient {

    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") int id);
}
