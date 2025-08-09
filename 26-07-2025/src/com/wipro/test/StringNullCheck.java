package com.wipro.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringNullCheck {

    @Test
    public void testUpperCaseWithNull() {
        String str = null;

        assertThrows(NullPointerException.class, () -> {
            str.toUpperCase();
        });
    }
}
