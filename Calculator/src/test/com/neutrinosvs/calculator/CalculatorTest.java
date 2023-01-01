package com.neutrinosvs.calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    public void canAddZeroPlusZero() {
        int sum = calc.add(0, 0);
        assertEquals(0, sum);
    }

    @Test
    public void canAddOnePlusOne() {
        int sum = calc.add(1, 1);
        assertEquals(2, sum);
    }
    @Test
    public void canAddMaxIntPlusOne() {
        int sum  = calc.add(Integer.MAX_VALUE, 1);
        System.out.println(sum);
        assertEquals(Integer.MAX_VALUE + 1l, sum);
    }

    @Test
    public void annuityExample() {
     String answer = calc.calAnnunity("22000", 7, ".06", 1);
     assertEquals("$184,664.43", answer);
    }
}
