package com.vignesh.basics.strings;

import org.junit.jupiter.api.Test;

public class StringOps {

    @Test
    public void testReverseSB() {
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb.reverse());
    }

    @Test
    public void testRepeat() {
        System.out.println("hello".repeat(2));
    }
}
