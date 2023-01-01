package com.neutrinosvs.calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public String calAnnunity(String R, int t, String r, int n) {
        BigDecimal a = new BigDecimal(r).divide(new BigDecimal(n));
        BigDecimal b = a.add(BigDecimal.ONE);
        BigDecimal c = b.pow(n * t);
        BigDecimal d = c.subtract(BigDecimal.ONE);
        BigDecimal e = d.divide(a);
        BigDecimal f = e.multiply(new BigDecimal(R));
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        return currencyInstance.format(f);


    }
}
