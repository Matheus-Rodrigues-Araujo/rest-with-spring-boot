package com.rest_with_spring_boot.controllers;

import com.rest_with_spring_boot.math.SimpleMath;
import com.rest_with_spring_boot.converters.NumberConverter;
import com.rest_with_spring_boot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private final SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
        if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
    }

    @RequestMapping(value = "/sub/{n1}/{n2}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
        if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.subtraction(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
    }

    @RequestMapping(value = "/div/{n1}/{n2}", method = RequestMethod.GET)
    public String division(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
        if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.division(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
    }

    @RequestMapping(value = "/mult/{n1}/{n2}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
        if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.multiplication(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
    }

    @RequestMapping(value = "/sqrt/{n1}", method = RequestMethod.GET)
    public Double squareroot(@PathVariable(value = "n1") String n1) throws Exception {
        if (!NumberConverter.isNumeric(n1)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.squareRoot(NumberConverter.convertToDouble(n1));
    }

}
