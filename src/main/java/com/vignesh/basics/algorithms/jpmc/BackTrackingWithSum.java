package com.vignesh.basics.algorithms.jpmc;

import java.util.Arrays;
import java.util.Stack;

/*
 * possible 3 elements with sum <= 6
 */
public class BackTrackingWithSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 7, 3, 5, 2, 1, 10};
        BackTrackingWithSum app = new BackTrackingWithSum(3, 6);
        app.solve(arr);
    }

    public BackTrackingWithSum(int k, int sum) {
        this.k = k;
        this.sum = sum;
    }

    final int k;
    final int sum;

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
            int cs = path.stream().mapToInt(Integer::intValue).sum();
            if (cs <= sum) {
                System.out.println(Arrays.toString(path.toArray(new Integer[path.size()])));
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.push(arr[i]);
            solution(path, arr, i + 1);
            path.pop();
        }
    }
}
