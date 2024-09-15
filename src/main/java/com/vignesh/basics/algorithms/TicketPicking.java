package com.vignesh.basics.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketPicking {
    static int maxTickets(List<Integer> tickets) {
        Collections.sort(tickets);
        int max=0;
        int sub=0;
        Integer last = null;
        for(Integer i:tickets) {
            if(sub > 0 && i > last+1) {
                if(sub > max) {
                    max = sub;
                }
                sub=1;
            } else {
                sub++;
            }
            last = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int ans = maxTickets(new ArrayList<>(List.of(8,5,4,8,4)));
        System.out.println("ans = " + ans);
    }
}
