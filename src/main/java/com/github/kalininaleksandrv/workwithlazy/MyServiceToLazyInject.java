package com.github.kalininaleksandrv.workwithlazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MyServiceToLazyInject {

    private final MyLazyBin myLazyBin;


    /*
    we use first @Lazy here or above constructor or above autowired
    and second above lazy service itself
    to switch on lazy behavior
     */
    public MyServiceToLazyInject(@Lazy MyLazyBin myLazyBin) {
        this.myLazyBin = myLazyBin;
    }


    public String lazyOrNot (boolean isLazy) {
        if(isLazy){
            return myLazyBin.process();
        } else {
            return "ordinary cheap operation";
        }

    }
}
