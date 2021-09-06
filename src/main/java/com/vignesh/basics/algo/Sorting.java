package com.scb.dqmf.playground.algo;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] elements = new int[]{5, 3, 2, 8, 1, 6, 9, 4, 7};
//        bubbleSort(elements);
//        selectionSort(elements);
//        insertionSort(elements);
        elements = mergeSort(elements);
        System.out.println("sorted = " + Arrays.toString(elements));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    static int[] mergeSort(int[] arr) {
        if(arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
//        System.out.println("left = " + Arrays.toString(left));
//        System.out.println("right = " + Arrays.toString(right));
        return merge(mergeSort(left),mergeSort(right));
    }

    static int[] merge(int[] left,int[] right) {
        System.out.println(Arrays.toString(left)+" "+Arrays.toString(right));
        int[] result = new int[left.length+ right.length];
        int resultIndex = 0;
        int leftIndex = 0;int rightIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }
        int remainingLeft = left.length-leftIndex;
        int remainingRight = right.length-rightIndex;
        System.arraycopy(left,leftIndex,result,resultIndex,remainingLeft);
        System.arraycopy(right,rightIndex,result,resultIndex+remainingLeft,remainingRight);
        return result;
    }
}
