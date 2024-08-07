package com.liooos.example.other.base;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindClosestToZero {

    /**
     * 단순 반복문
     *
      * @param arr
     * @return
     * @throws IllegalAccessException
     */
    public static int findClosestToZero(int[] arr) throws IllegalAccessException {
        if (arr == null || arr.length == 0) {
            throw new IllegalAccessException("Array must not be null or Empty");
        }

        int closest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((Math.abs(arr[i]) < Math.abs(closest)) ||
                    ((Math.abs(arr[i]) == Math.abs(closest)) && (arr[i] > closest))) {
                closest = arr[i];
            }
        }
        return closest;
    }

    /**
     * 정렬 및 이진검색
     *
     * @param arr
     * @return
     */
    public static int findClosestToZeroWithSortAndBinarySearch(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or Empty");
        }

        // 정렬
        Arrays.sort(arr);

        // 이진 검색
        int closestNumber = arr[0];
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(arr[mid]) < Math.abs(closestNumber)) {
                closestNumber = arr[mid];
            }

            if (arr[mid] < 0) {
                left = mid + 1;
            } else if (arr[mid] > 0) {
                right = mid - 1;
            } else {
                return arr[mid];
            }
        }
        return closestNumber;
    }

    /**
     * 우선순위 큐
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findClosestToZeroWithPriorityQueue(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(b) - Math.abs(a));

        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
