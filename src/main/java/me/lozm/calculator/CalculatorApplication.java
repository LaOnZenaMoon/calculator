package me.lozm.calculator;

import me.lozm.calculator.service.CalculatorService;

public class CalculatorApplication {

    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        service.run();
    }

}
