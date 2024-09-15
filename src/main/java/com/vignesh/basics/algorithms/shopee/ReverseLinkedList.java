package com.vignesh.basics.algorithms.shopee;

import com.vignesh.basics.datastructure.MyLinkedList;

import java.util.Arrays;

public class ReverseLinkedList {

    private static void reverseRecursive(MyLinkedList<Integer> list, MyLinkedList.Node<Integer> node) {
        if (node == null) {
            return;
        }
        list.add(node.getItem());
        if (node.getPrev() != null) {
            reverseRecursive(list, node.getPrev());
        }
    }

    private static MyLinkedList<Integer> getReverseList(MyLinkedList<Integer> list) {
        MyLinkedList<Integer> reverse = new MyLinkedList<>();
        reverseRecursive(reverse, list.getLast());
        return reverse;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("List : " + Arrays.toString(list.toArray()));
        MyLinkedList<Integer> reverse = getReverseList(list);
        System.out.println("Reverse : " + Arrays.toString(reverse.toArray()));
    }
}
