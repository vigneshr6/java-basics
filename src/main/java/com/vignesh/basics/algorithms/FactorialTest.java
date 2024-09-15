package com.vignesh.basics.algorithms;

import java.util.Scanner;

public class FactorialTest {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine()) {
                String string = scan.nextLine();
                String resp = factorial(Integer.valueOf(string));
                System.out.println(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String factorial(int n) {
        long resp = fact(n);
        while (String.valueOf(resp).length() > 3 && resp % 10 == 0) {
            resp = resp / 10;
        }
        String respSt = String.valueOf(resp);
        return respSt.substring(respSt.length() - 3);
    }

    private static long fact(int n) {
        if (n < 2) {
            return 1;
        }
        long resp = n;
        while(n > 1) {
            resp = resp * (n-1);
            n--;
        }
        return resp;
    }

}
