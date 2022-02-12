package com.vignesh.basics.algo.paypal;

public class BinarySearch {
    public static void main(String[] args) {
        int i = find(new int[]{0, 1, 2, 6, 8, 14, 16});
//        int i = find(new int[]{1,2,5,6,8,12,20});
        System.out.println("i = " + i);
    }

    static int find(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int m = (high + low) / 2;
        while (m > low && m < high) {
            if (arr[m] > m) {
                high = m;
            } else {
                low = m;
            }
            m = (high + low) / 2;
        }
        return m < 1 ? m: m+1;
    }
}
