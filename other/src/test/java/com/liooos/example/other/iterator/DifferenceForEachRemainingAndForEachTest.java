package com.liooos.example.other.iterator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DifferenceForEachRemainingAndForEachTest {
    // 직원 정보 배열
    private final List<String> employeeDetails = Arrays.asList(
            "Alice Johnson, 30, Manager",
            "Bob Smith, 25, Developer",
            "Charlie Brown, 28, Designer"
    );
    // 예상 출력
    String expectedReport =
            "Employee: Alice Johnson, 30, Manager\n" +
                    "Employee: Bob Smith, 25, Developer\n" +
                    "Employee: Charlie Brown, 28, Designer\n";

    // iterator.forEachRemaining() 활용
    @Test
    public void givenEmployeeDetails_whenUsingIterator_thenGenerateEmployeeReport() {
        StringBuilder report = new StringBuilder();
        employeeDetails.iterator().forEachRemaining(employee ->
                report.append("Employee: ").append(employee).append("\n")
        );

        assertEquals(expectedReport, report.toString());
    }

    // iterable.forEach() 활용
    @Test
    public void givenEmployeeDetails_whenUsingForEach_thenGenerateEmployeeReport() {
        StringBuilder report = new StringBuilder();
        employeeDetails.forEach(employee ->
                report.append("Employee: ").append(employee).append("\n")
        );

        assertEquals(expectedReport, report.toString());
    }

}