package com.vignesh.basics.algo;

import java.util.Arrays;

/*
* find min cost of house in each column
* same material should not be used in adjacent houses
 */
public class CostManagement {
    public static void main(String[] args) {
        int[][] houses = new int[][]{
                {3, 1, 1},
                {1, 2, 3},
                {2, 3, 2}
        };
        findMinCost(houses);
    }
    static void findMinCost(int[][] houses) {
        int minFirst = 0;
        int rows = houses.length;
        int cols = houses[0].length;
        for(int i=0;i<rows;i++) {
            int val = houses[i][0];
            if(minFirst <1 || val < minFirst) {
                minFirst = val;
            }
        }
        int[] costs = new int[cols];
        Arrays.fill(costs,0);
        costs[0] = minFirst;
        for(int i=1;i<cols;i++) {
            for(int j=0;j<rows;j++) {
                int val = houses[j][i];
//                check left-right houses uses same material
                if((j > 0 && val == houses[j-1][i]) || (j< rows-1 && val == houses[j+1][i])) {
                    continue;
                }
//                check up-down houses uses same material
                if((i>0 && val == houses[j][i-1]) || (i<cols-1 && val == houses[j][i+1])) {
                    continue;
                }
                if(costs[i] < 1 || val < costs[i]) {
                    costs[i] = val;
                }
            }
        }
        System.out.println(Arrays.toString(costs));
    }
}
