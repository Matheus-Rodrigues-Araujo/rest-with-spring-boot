package com.rest_with_spring_boot;

import com.rest_with_spring_boot.converters.NumberConverter;

public class SimpleMath {
    public Double sum(Double n1, Double n2) {
        return n1 + n2;
    }

    public Double subtraction(Double n1, Double n2) {
        return n1 - n2;
    }

    public String division(Double n1, Double n2) {
        double result = n1 / n2;
        return String.format("%.2f", result);
    }

    public Double multiplication(Double n1, Double n2) {
        return n1 * n2;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }

}
