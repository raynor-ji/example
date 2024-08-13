package com.liooos.example.other.iterator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GetIndexAfterSortTest {

    // 기초 정보
    int[] array = {40, 10, 20, 30};

    @Test
    void givenArray_whenUsingCustomComparator_thenSortedIndicesMatchExpected() {
        // index array
        Integer[] indices = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }

        // array index sort
        Arrays.sort(indices, Comparator.comparingInt(i -> array[i]));

        assertArrayEquals(new Integer[]{1, 2, 3, 0}, indices);
    }

    @Test
    void givenArray_whenUsingStreamAPI_thenSortedIndicesMatchExpected() {
        // index array sort
        List<Integer> indices = IntStream.range(0, array.length)
                .boxed().sorted(Comparator.comparingInt(i -> array[i])).collect(Collectors.toList());

        assertIterableEquals(Arrays.asList(1, 2, 3, 0), indices);
    }

}