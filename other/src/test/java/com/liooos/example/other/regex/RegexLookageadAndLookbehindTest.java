package com.liooos.example.other.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RegexLookageadAndLookbehindTest {

    @Test
    void PositiveLookaheadAssertionTest() {
        String mainStatement = "import static org.junit.jupiter.api.Assertions.assertEquals;";

        Pattern pattern = Pattern.compile("import (?=static).+");

        Matcher matcher = pattern.matcher(mainStatement);

        assertTrue(matcher.find());
        assertEquals(mainStatement, matcher.group());

        assertFalse(pattern.matcher("import java.util.regex.Matcher;").find());
    }

    @Test
    void NegativeLookaheadAssertionTest() {
        String mainStatement = "import java.util.regex.Matcher;";
        Pattern pattern = Pattern.compile("import (?!static).+");

        Matcher matcher = pattern.matcher(mainStatement);
        assertTrue(matcher.find());
        assertEquals(mainStatement, matcher.group());

        assertFalse(pattern.matcher("import static org.junit.jupiter.api.Assertions.assertEquals;").find());
    }

    @Test
    void PositiveLookbehindAssertionTest() {
        String mainStatement = "import static org.junit.jupiter.api.Assertions.assertEquals;";
        Pattern pattern = Pattern.compile(".*(?<=jupiter).*assertEquals;");

        Matcher matcher = pattern.matcher(mainStatement);
        assertTrue(matcher.find());
        assertEquals(mainStatement, matcher.group());

        assertFalse(pattern.matcher("import static org.junit.Assert.assertEquals;").find());
    }

    @Test
    void NegativeLookbehindAssertionTest() {
        String mainStatement = "import static org.junit.Assert.assertEquals;";
        Pattern pattern = Pattern.compile(".*(?<!jupiter.{0,30})assertEquals;");

        Matcher matcher = pattern.matcher(mainStatement);
        assertTrue(matcher.find());
        assertEquals(mainStatement, matcher.group());

        assertFalse(pattern.matcher("import static org.junit.jupiter.api.Assertions.assertEquals;").find());
    }

}