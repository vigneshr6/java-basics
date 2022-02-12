package com.vignesh.basics.algo;

import java.util.Arrays;
import java.util.Stack;

/*
 * print combination of K elements from N elements of array
 */
public class BackTracking {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        BackTracking app = new BackTracking(3);
        app.solve(arr);
    }

    public BackTracking(int k) {
        this.k = k;
    }

    final int k;

    void solve(int[] arr) {
        Stack<Integer> path = new Stack<>();
        for (int i = 0; (arr.length - i) >= k; i++) {
            path.push(arr[i]);
            solution(path, arr, i + 1);
            path.pop();
        }
    }

    void solution(Stack<Integer> path, int[] arr, int start) {
        if (path.size() == k) {
            System.out.println(Arrays.toString(path.toArray(new Integer[path.size()])));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.push(arr[i]);
            solution(path, arr, i + 1);
            path.pop();
        }
    }
}