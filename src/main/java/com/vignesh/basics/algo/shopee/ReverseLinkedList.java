package com.vignesh.basics.algo.shopee;

import com.vignesh.basics.datastructure.MyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

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

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("List : " + Arrays.toString(list.toArray()));
        MyLinkedList<Integer> reverse = new MyLinkedList<>();
        reverseRecursive(reverse, list.getLast());
        System.out.println("Reverse : " + Arrays.toString(reverse.toArray()));
    }
}
