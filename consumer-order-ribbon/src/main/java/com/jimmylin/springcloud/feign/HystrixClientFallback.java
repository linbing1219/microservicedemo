package com.jimmylin.springcloud.feign;

import com.jimmylin.springcloud.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements IFeignClient {
    @Override
    public User getUser(int id) {
        return new User(-101);
    }
}
