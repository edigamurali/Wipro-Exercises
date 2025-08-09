package com.wipro.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CheckString {

    @Test
    void test() {
        String name = "MURALI";
        assertTrue(name.equals(name.toUpperCase()));
    }
}
