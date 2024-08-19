package com.liooos.example.other.regex;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class RegexReplaceStringByBackReferenceAndLookaround {
    private static final int ITERATIONS_COUNT = 1000;

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        String testString = "*example*text**with*many*asterisks**".repeat(ITERATIONS_COUNT);
    }

    @Benchmark
    public void backReference(BenchmarkState state) {
        state.testString.replaceAll("(^\\*)|(\\*$)|\\*", "$1$2");
    }

    @Benchmark
    public void lookaround(BenchmarkState state) {
        state.testString.replaceAll("(?<!^)\\*+(?!$)", "");
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(RegexReplaceStringByBackReferenceAndLookaround.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
