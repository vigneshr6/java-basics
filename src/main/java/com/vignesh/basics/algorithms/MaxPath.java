package com.vignesh.basics.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Morgan Stanley interview
 */
public class MaxPath {
    static List<List<Node>> allPaths = new ArrayList<>();

    /*
    * find path with max sum
    * can skip the next immediate node
     */
    public static void main(String[] args) {
        int[] arr = new int[]{30, -2, -10, -15, 5, 10};
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            Node head;
            if (nodes[i] == null) {
                head = new Node(i, arr[i]);
                nodes[i] = head;
            } else {
                head = nodes[i];
            }
            head.left = nodes[i + 1];
            if (head.left == null) {
                head.left = new Node(i + 1, arr[i + 1]);
                nodes[i + 1] = head.left;
            }
            if (i < arr.length - 2) {
                head.right = nodes[i + 2];
                if (head.right == null) {
                    head.right = new Node(i + 2, arr[i + 2]);
                    nodes[i + 2] = head.right;
                }
            }
        }
        parseDepth(nodes[0], new ArrayList<>());
        Integer max = null;
        int[] maxPath = null;
        for (List<Node> path : allPaths) {
            int sum = path.stream().mapToInt(Node::getValue).sum();
            if ( max ==null || sum > max) {
                max = sum;
                maxPath = path.stream().mapToInt(Node::getValue).toArray();
            }
        }
        System.out.println("max = " + max);
        System.out.println("maxPath = " + Arrays.toString(maxPath));
    }

    private static class Node {
        final int index;
        final int value;
        Node left;
        Node right;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    static void parseDepth(Node head, List<Node> parsed) {
        ArrayList<Node> nodes = new ArrayList<>(parsed);
        nodes.add(head);
        if (head.left != null) {
            parseDepth(head.left, nodes);
        }
        if (head.right != null) {
            parseDepth(head.right, nodes);
        }
        if (head.left == null && head.right == null) {
            parsed.add(head);
            System.out.println(Arrays.toString(parsed.stream().mapToInt(Node::getValue).toArray()));
            allPaths.add(parsed);
        }
    }
}
