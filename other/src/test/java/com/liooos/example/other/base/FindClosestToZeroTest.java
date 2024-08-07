package com.liooos.example.other.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindClosestToZeroTest {

    @Test
    void whenFindingClosestToZero_thenResultShouldBeCorrect() throws IllegalAccessException {
        int[] arr = {1, 60, -10, 70, -80, 85};
        assertEquals(1, FindClosestToZero.findClosestToZero(arr));
    }

    @Test
    void whenFindingClosestToZeroWithSortAndBinarySearch_thenResultShouldBeCorrect() {
        int[] arr = {1, 60, -10, 70, -80, 85};
        assertEquals(1, FindClosestToZero.findClosestToZeroWithSortAndBinarySearch(arr));
    }

    @Test
    void whenFindingClosestToZeroWithPriorityQueue_thenResultShouldBeCorrect() {
        int[] arr = {1, 60, -10, 70, -80, 85};
        assertEquals(1, FindClosestToZero.findClosestToZeroWithPriorityQueue(arr, 1));
    }

}