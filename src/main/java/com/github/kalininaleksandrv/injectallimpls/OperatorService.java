package com.github.kalininaleksandrv.injectallimpls;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OperatorService {


    private final Map<String, Operator> operators;

    /*
      when spring see the list of implementations it will inject them all
    */
    public OperatorService(List<Operator> operators) {
        /*
        then we transform list to map with class names to chose exact implementation lately
         */
        this.operators = operators.stream()
                .collect(Collectors.toMap(k -> k.getClass().getSimpleName(), Function.identity()));
    }

    /*
    here we perform chain of responsibility
     */
    public String performOperations() {
        DataObj data = new DataObj();
        operators.values().forEach(operator -> operator.operate(data));
        return data.getData();
    }

    public String performExactOperations(String operatorName) {
        Operator exactOperator =  Optional.ofNullable(operators.get(operatorName))
                .orElseThrow(() -> new RuntimeException("Operator not found"));
        DataObj data = new DataObj();
        exactOperator.operate(data);
        return data.getData();
    }
}
