package com.rest_with_spring_boot;

import com.rest_with_spring_boot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(n1) + convertToDouble(n2);
    }

    @RequestMapping(value = "/sub/{n1}/{n2}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value="n1") String n1, @PathVariable(value="n2") String n2) throws Exception{
        if(!isNumeric(n1) || !isNumeric(n2)) throw new Exception();
        return convertToDouble(n1) - convertToDouble(n2);
    }

    @RequestMapping(value = "/div/{n1}/{n2}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
        if(!isNumeric(n1) || !isNumeric(n2)){
            throw new Exception();
        }
        return convertToDouble(n1)/convertToDouble(n2);
    }

    @RequestMapping(value = "/mult/{n1}/{n2}", method = RequestMethod.GET) // mapear rota e verbo HTTP
    public Double multiplication(@PathVariable(value="n1") String n1, @PathVariable(value= "n2") String n2 ) throws Exception { // Definição de parâmetros
        if(!isNumeric(n1) || !isNumeric(n2)){
            throw new Exception();
        }
        return convertToDouble(n1) * convertToDouble(n2);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");

        if (isNumeric((number))) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
