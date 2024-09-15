package com.vignesh.basics.algorithms.jpmc;

import java.util.Stack;
import java.util.stream.Collectors;

public class BracesValidation {
    public static void main(String[] args) {
        int swaps = countSwaps(")))(())(((".toCharArray());
        System.out.println("swaps = " + swaps);
    }

    static int countSwaps(char[] input) {
        Stack<Character> letters = new Stack<>();
        int open =0;
        int close = 0;
        for(int i=0;i<input.length;i++) {
            char c  = input[i];
            if (c == ')' && !letters.isEmpty() && letters.peek() == '(') {
                letters.pop();
                open--;
            } else {
                if(c == '(') {
                    open++;
                } else {
                    close++;
                }
                letters.push(c);
            }
        }
        if(letters.size() == 0) {
            return 0;
        }
        if(open != close) {
            return -1;
        }
        int n = letters.size();
        char[] remaining = letters.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
        char t = remaining[0];
        remaining[0] = remaining[n-1];
        remaining[n-1] = t;
        return 1+countSwaps(remaining);
    }
}
