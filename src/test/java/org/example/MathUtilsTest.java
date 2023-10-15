package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    void setup (){
      mathUtils = new MathUtils();
    }

    @Test
    public void testAddPositiveIntegers() {
        int result = mathUtils.add(10, 25);
        assertEquals(35, result);
    }

    @Test
    public void testAddPositiveIntegerToZero() {
        int result = mathUtils.add(7, 0);
        assertEquals(7, result);
    }

    @Test
    public void testAddNegativeToPositive() {
        int result = mathUtils.add(-3, 5);
        assertEquals(2, result);
    }

    @Test
    public void testAddLargeIntegers() {
        int result = mathUtils.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void testBiggerFirstArgumentIsLarger() {
        boolean result = mathUtils.bigger(15, 3);
        assertTrue(result);
    }

    @Test
    public void testBiggerSecondArgumentIsLarger() {
        boolean result = mathUtils.bigger(5, 10);
        assertFalse(result);
    }

    @Test
    public void testBiggerEqualArguments() {
        boolean result = mathUtils.bigger(5, 5);
        assertFalse(result);
    }

    @Test
    public void testDivide () {
        float result = mathUtils.divide(10.5f, 4.8f);
        assertEquals(result,2.1875, 0.001);
    }

    @Test
    public void testMultiply() {
        float result = mathUtils.multiply(5.0f, 3.0f);
        assertEquals(result, 15.0, 0.001);
    }

    @ParameterizedTest
    @ValueSource(floats = {1.6f, 2.98f, 8.44f, 4.7f, 5.06f})
    public void testSquare(float number) {
        float result = mathUtils.square(number);
        assertEquals(number * number, result, 0.001);
    }

}
