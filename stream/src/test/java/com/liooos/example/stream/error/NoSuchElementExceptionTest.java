package com.liooos.example.stream.error;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class NoSuchElementExceptionTest {

    @Test
    public void givenEmptyOptional_whenCallingGetMethod_thenThrowNoSuchElementException() {
        List<String> names = List.of("William", "Amelia", "Albert", "Philip");
        Optional<String> emptyOptional = names.stream()
                .filter(name -> name.equals("Emma"))
                .findFirst();

        assertThrows(NoSuchElementException.class, emptyOptional::get);
    }

    @Test
    public void givenEmptyOptional_whenUsingIsPresentMethod_thenReturnDefault() {
        List<String> names = List.of("Tyler", "Amelia", "James", "Emma");
        Optional<String> emptyOptional = names.stream()
                .filter(name -> name.equals("Lucas"))
                .findFirst();

        String name = "unknown";
        if (emptyOptional.isPresent()) {
            name = emptyOptional.get();
        }

        assertEquals("unknown", name);
    }

    @Test
    public void givenEmptyOptional_whenUsingOrElseMethod_thenReturnDefault() {
        List<String> names = List.of("Nicholas", "Justin", "James");
        Optional<String> emptyOptional = names.stream()
                .filter(name -> name.equals("Lucas"))
                .findFirst();

        String name = emptyOptional.orElse("unknown");

        assertEquals("unknown", name);
    }

    @Test
    public void givenEmptyOptional_whenUsingOrElseGetMethod_thenReturnDefault() {
        List<String> names = List.of("Thomas", "Catherine", "David", "Olivia");
        Optional<String> emptyOptional = names.stream()
                .filter(name -> name.equals("Liam"))
                .findFirst();

        String name = emptyOptional.orElseGet(() -> "unknown");

        assertEquals("unknown", name);
    }
}
