package com.liooos.example.other.regex;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegexReplaceStringByBackReferenceAndLookaroundTest {

    @Test
    void replaceByBackReference() {
        String str = "**te*xt**";
        String replaced = str.replaceAll("(^\\*)|(\\*$)|\\*", "$1$2");
        assertEquals("*text*", replaced);
    }

    @Test
    void replaceByLookaround() {
        String str = "**te*xt**";
        String replacedUsingLookaround = str.replaceAll("(?<!^)\\*+(?!$)", "");
        assertEquals("*text*", replacedUsingLookaround);
    }

    private static final int ITERATIONS_COUNT = 1000;

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        String testString = "*example*text**with*many*asterisks**".repeat(ITERATIONS_COUNT);
    }

}