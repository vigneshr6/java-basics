package com.vignesh.basics.algorithms.tekion;

import java.util.HashMap;
import java.util.List;

public class Tekion {

    //

    static void findNotes(List<Integer> options, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = target;
        for(int i=options.size()-1;i>=0;i--) {
            int o = options.get(i);
            if(o > temp) {
                continue;
            }
            int q = temp/o;
            int r = temp%o;
            map.put(o,q);
            temp = r;
        }
        map.forEach((k,v) -> System.out.println(k+" :: "+v));
    }

    static void rotate(int[][] matrix) {
        for(int i= 0;i<matrix.length;i++){
            for(int j=matrix[i].length-1;j>=0;j--) {
                System.out.print(matrix[j][i]+",");
                if(j == 0) {
                    System.out.println();
                }
            }
        }
    }


    public static void main(String[] args) {
//        findNotes(Arrays.asList(1,2,5,10,20,50,100), 9724);
        int[][] x = new int[3][3];
        int counter=1;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                x[i][j]=counter;
                counter++;
            }
        }
        //1,2,3
        //4,5,6
        //7,8,9
        rotate(x);
    }
}