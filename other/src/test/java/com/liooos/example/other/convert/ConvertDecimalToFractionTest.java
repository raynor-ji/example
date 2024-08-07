package com.liooos.example.other.convert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConvertDecimalToFractionTest {

    @Test
    void convertDecimalToFractionUsingMultiplyingWithPowerOf10() {
        Assertions.assertEquals("5/10", ConvertDecimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.5));
        Assertions.assertEquals("1/10", ConvertDecimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.1));
        Assertions.assertEquals("6/10", ConvertDecimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.6));
        Assertions.assertEquals("85/100", ConvertDecimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.85));
        Assertions.assertEquals("125/100", ConvertDecimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(1.25));
        Assertions.assertEquals("1333333333/1000000000", ConvertDecimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(1.333333333));
    }

    @Test
    void convertDecimalToFractionUsingGCD() {
        Assertions.assertEquals("1/2", ConvertDecimalToFraction.convertDecimalToFractionUsingGCD(0.5));
        Assertions.assertEquals("1/10", ConvertDecimalToFraction.convertDecimalToFractionUsingGCD(0.1));
        Assertions.assertEquals("3/5", ConvertDecimalToFraction.convertDecimalToFractionUsingGCD(0.6));
        Assertions.assertEquals("17/20", ConvertDecimalToFraction.convertDecimalToFractionUsingGCD(0.85));
        Assertions.assertEquals("5/4", ConvertDecimalToFraction.convertDecimalToFractionUsingGCD(1.25));
        Assertions.assertEquals("1333333333/1000000000", ConvertDecimalToFraction.convertDecimalToFractionUsingGCD(1.333333333));
    }

    @Test
    void convertDecimalToFractionUsingApacheCommonsMath() {
        Assertions.assertEquals("1 / 2", ConvertDecimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.5));
        Assertions.assertEquals("1 / 10", ConvertDecimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.1));
        Assertions.assertEquals("3 / 5", ConvertDecimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.6));
        Assertions.assertEquals("17 / 20", ConvertDecimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.85));
        Assertions.assertEquals("5 / 4", ConvertDecimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(1.25));
        Assertions.assertEquals("4 / 3", ConvertDecimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(1.333333333));
    }

    @Test
    void convertDecimalToFractionUsingGCDRepeating() {
        Assertions.assertEquals("1/2", ConvertDecimalToFraction.convertDecimalToFractionUsingGCDRepeating(0.5));
        Assertions.assertEquals("17/20", ConvertDecimalToFraction.convertDecimalToFractionUsingGCDRepeating(0.85));
        Assertions.assertEquals("5/4", ConvertDecimalToFraction.convertDecimalToFractionUsingGCDRepeating(1.25));
        Assertions.assertEquals("4/3", ConvertDecimalToFraction.convertDecimalToFractionUsingGCDRepeating(1.333333333));
        Assertions.assertEquals("7/9", ConvertDecimalToFraction.convertDecimalToFractionUsingGCDRepeating(0.777777));
    }
}