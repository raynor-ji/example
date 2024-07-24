package com.liooos.example.other.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeceimalToFractionTest {

    @Test
    void convertDecimalToFractionUsingMultiplyingWithPowerOf10() {
        Assertions.assertEquals("5/10", DeceimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.5));
        Assertions.assertEquals("1/10", DeceimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.1));
        Assertions.assertEquals("6/10", DeceimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.6));
        Assertions.assertEquals("85/100", DeceimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(0.85));
        Assertions.assertEquals("125/100", DeceimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(1.25));
        Assertions.assertEquals("1333333333/1000000000", DeceimalToFraction.convertDecimalToFractionUsingMultiplyingWithPowerOf10(1.333333333));
    }

    @Test
    void convertDecimalToFractionUsingGCD() {
        Assertions.assertEquals("1/2", DeceimalToFraction.convertDecimalToFractionUsingGCD(0.5));
        Assertions.assertEquals("1/10", DeceimalToFraction.convertDecimalToFractionUsingGCD(0.1));
        Assertions.assertEquals("3/5", DeceimalToFraction.convertDecimalToFractionUsingGCD(0.6));
        Assertions.assertEquals("17/20", DeceimalToFraction.convertDecimalToFractionUsingGCD(0.85));
        Assertions.assertEquals("5/4", DeceimalToFraction.convertDecimalToFractionUsingGCD(1.25));
        Assertions.assertEquals("1333333333/1000000000", DeceimalToFraction.convertDecimalToFractionUsingGCD(1.333333333));
    }

    @Test
    void convertDecimalToFractionUsingApacheCommonsMath() {
        Assertions.assertEquals("1 / 2", DeceimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.5));
        Assertions.assertEquals("1 / 10", DeceimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.1));
        Assertions.assertEquals("3 / 5", DeceimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.6));
        Assertions.assertEquals("17 / 20", DeceimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(0.85));
        Assertions.assertEquals("5 / 4", DeceimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(1.25));
        Assertions.assertEquals("4 / 3", DeceimalToFraction.convertDecimalToFractionUsingApacheCommonsMath(1.333333333));
    }

    @Test
    void convertDecimalToFractionUsingGCDRepeating() {
        Assertions.assertEquals("1/2", DeceimalToFraction.convertDecimalToFractionUsingGCDRepeating(0.5));
        Assertions.assertEquals("17/20", DeceimalToFraction.convertDecimalToFractionUsingGCDRepeating(0.85));
        Assertions.assertEquals("5/4", DeceimalToFraction.convertDecimalToFractionUsingGCDRepeating(1.25));
        Assertions.assertEquals("4/3", DeceimalToFraction.convertDecimalToFractionUsingGCDRepeating(1.333333333));
        Assertions.assertEquals("7/9", DeceimalToFraction.convertDecimalToFractionUsingGCDRepeating(0.777777));
    }
}