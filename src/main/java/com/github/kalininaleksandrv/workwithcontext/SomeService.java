package com.github.kalininaleksandrv.workwithcontext;

public class SomeService {

    private int bound = 0;

    public String getRandomNumberAsString() {
        return String.valueOf(bound);
    }

    public void setBound(int bound) {
        this.bound = bound;
    }
}
