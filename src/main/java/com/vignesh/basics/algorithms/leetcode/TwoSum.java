package com.vignesh.basics.algorithms.leetcode;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> diffs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(diffs.containsKey(cur)) {
                int x = diffs.get(cur);
                return new int[]{x, i};
            }
            diffs.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum app = new TwoSum();
        int[] ans = app.twoSum(new int[]{-3,4,3,90}, 0);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}
