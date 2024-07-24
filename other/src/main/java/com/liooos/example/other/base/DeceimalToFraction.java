package com.liooos.example.other.base;

import org.apache.commons.math3.fraction.Fraction;

public class DeceimalToFraction {

    /**
     * 1. pow를 활용한 분수 변환
     *
     * @param decimal
     * @return
     */
    public static String convertDecimalToFractionUsingMultiplyingWithPowerOf10(double decimal) {
        String decimalStr = String.valueOf(decimal);
        int decimalPlaces = decimalStr.length() - decimalStr.indexOf('.') - 1;

        long denominator = (long) Math.pow(10, decimalPlaces);
        long numerator = (long) (decimal * denominator);

        return numerator + "/" + denominator;
    }

    /**
     * 2. pow + 최대공약수를 활용한 분수 변환
     *
     * @param decimal
     * @return
     */
    public static String convertDecimalToFractionUsingGCD(double decimal) {
        String decimalStr = String.valueOf(decimal);
        int decimalPlaces = decimalStr.length() - decimalStr.indexOf('.') - 1;
        long denominator = (long) Math.pow(10, decimalPlaces);
        long numerator = (long) (decimal * denominator);

        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    /**
     * 최대 공약수 구하기
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * 3. Apache Commons Math 라이브러리를 활용한 분수 변환
     *
     * @param decimal
     * @return
     */
    public static String convertDecimalToFractionUsingApacheCommonsMath(double decimal) {
        Fraction fraction = new Fraction(decimal);
        return fraction.toString();
    }

    public static String extractRepeatingDecimal(String fractionalPart) {
        int length = fractionalPart.length();
        for (int i = 1; i <= length / 2; i++) {
            String sub = fractionalPart.substring(0, i);
            boolean repeating = true;
            for (int j = i; j + i <= length; j += i) {
                if (!fractionalPart.substring(j, j + i).equals(sub)) {
                    repeating = false;
                    break;
                }
            }
            if (repeating) {
                return sub;
            }
        }
        return "";
    }

    /**
     * 4. 순환소수 처리
     *
     * @param decimal
     * @return
     */
    public static String convertDecimalToFractionUsingGCDRepeating(double decimal) {
        String decimalStr = String.valueOf(decimal);
        int indexOfDot = decimalStr.indexOf('.');
        String afterDot = decimalStr.substring(indexOfDot + 1);
        String repeatingNumber = extractRepeatingDecimal(afterDot);

        if ("".equals(repeatingNumber)) {
            return convertDecimalToFractionUsingGCD(decimal);
        } else {
            int n = repeatingNumber.length();
            int repeatingValue = Integer.parseInt(repeatingNumber);
            int integerPart = Integer.parseInt(decimalStr.substring(0, indexOfDot));
            int denominator = (int) Math.pow(10, n) - 1;
            int numerator = repeatingValue + (integerPart * denominator);
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            return numerator + "/" + denominator;
        }
    }
}
