package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class CalculatorTest
{
    @Test
    public void test()
    {
        CalculatorService c = new CalculatorService();
        int r = c.add(5 , 6);
        assertEquals(11 , r);
    }
}
