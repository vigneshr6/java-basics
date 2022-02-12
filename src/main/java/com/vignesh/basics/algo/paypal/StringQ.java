package com.vignesh.basics.algo.paypal;

import java.util.ArrayList;
import java.util.List;

public class StringQ {

    public static void main(String[] args) {
        print("ABCDEFGH",3);
    }

    static void print(String str,int n) {
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++) {
            for (int i = j; i < str.length(); i += n) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());

        int cr = 1;
        List<String> rows = new ArrayList<>();
        for(int i=0;i<str.length();i++) {

        }
    }
}
