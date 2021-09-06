package com.vignesh.basics.algo;

public class LeftRightShift {

    public static void main(String[] args) {
        String rotated = rotate("abcd", 10, 7);
        System.out.println("rotated = " + rotated);
    }

    private static String rotate(String s, int ls, int rs) {
        int n = s.length();
        char[] result = new char[n];
        int x = ls - rs;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int ni = ((i + n) - x) % n;
            result[ni] = c;
        }
        return new String(result);
    }
}
