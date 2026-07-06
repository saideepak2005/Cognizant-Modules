package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {

    CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,20,30",
            "5,5,10"
    })
    void testAdd(int a,int b,int expected){

        assertEquals(expected, calculatorService.add(a,b));

    }

}