package com.github.kalininaleksandrv.injectallimpls;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {

    /*
    when spring see the list of implementations it will inject them all
     */
    private final List<Operator> operators;

    public OperatorService(List<Operator> operators) {
        this.operators = operators;
    }

    /*
    here we perform chain of responsibility
     */
    public String performOperations() {
        DataObj data = new DataObj();
        operators.forEach(operator -> operator.operate(data));
        return data.getData();
    }
}
