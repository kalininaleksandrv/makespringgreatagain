package com.github.kalininaleksandrv.injectallimpls;

import org.springframework.stereotype.Component;

@Component
public class ThirdOperator implements Operator{
    @Override
    public void operate(DataObj data) {
        data.setData(data.getData() + " after operator 3 ");
    }
}
