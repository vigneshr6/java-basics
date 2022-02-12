package com.vignesh.basics.interview.wm;

import java.io.Serializable;
import java.util.*;

public class TopView implements Serializable {

    public static void main(String[] args) {
        Node four = new Node(4);
        Node three = new Node(3);
        four.left = three;
        Node five = new Node(5);
        four.right = five;
        Node one = new Node(1);
        three.right = one;
        Node six = new Node(6);
        five.right = six;
        Node two = new Node(2);
        one.left = two;
        Node seven = new Node(7);
        one.right = seven;
        printTopView(four);
    }

    private static void printTopView(Node root) {
        Stack<XAxis> nodes = new Stack<>();
        XAxis xa = new XAxis(0, 0, root);
        nodes.push(xa);
        SortedSet<XAxis> result = new TreeSet<>();
        bds(result, nodes, 0, 0);
        System.out.println(result.toString());
    }

    private static void bds(SortedSet<XAxis> result, Stack<XAxis> nodes, int y, int x) {
        if (nodes.isEmpty()) {
            return;
        }
        while (!nodes.isEmpty()) {
            XAxis xa = nodes.pop();
            result.add(xa);
            if (xa.n.left != null)
                nodes.push(new XAxis(xa.x - 1, xa.y + 1, xa.n.left));
            if (xa.n.right != null)
                nodes.push(new XAxis(xa.x + 1, xa.y + 1, xa.n.right));
        }
    }


    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private static class XAxis implements Comparable {
        int x;
        int y;
        Node n;

        XAxis(int x, int y, Node n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")=" + n.val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            XAxis xAxis = (XAxis) o;
            return x == xAxis.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, n);
        }

        @Override
        public int compareTo(Object o) {
            XAxis xAxis = (XAxis) o;
            return x - xAxis.x;
        }
    }
}
