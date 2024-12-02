package com.vignesh.basics.algorithms.leetcode;

public class LengthOfNonRepeat {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        char[] letters = s.toCharArray();
        String cur = String.valueOf(letters[0]);
        int max = 1;
        for (int i = 1; i < letters.length; i++) {
            char c = letters[i];
            if (!cur.contains(String.valueOf(c))) {
                cur = cur.concat(String.valueOf(c));
                if (cur.length() > max) {
                    max = cur.length();
                }
            } else {
                cur = cur.substring(cur.indexOf(c) + 1).concat(String.valueOf(c));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfNonRepeat app = new LengthOfNonRepeat();
        int ans = app.lengthOfLongestSubstring("dvdf");
        System.out.println("ans = " + ans);
    }
}
