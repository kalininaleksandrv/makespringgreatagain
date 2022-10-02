package com.github.kalininaleksandrv.workwithlazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Lazy
public class MyLazyBin {

    @PostConstruct
    private void init () {
        System.out.println("now lazy bean is created");
    }

    public String process() {
        return "very expensive processing";
    }
}
