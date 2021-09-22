package com.vignesh.basics.datastructure;

class BinarySearchTreeDS {
    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node.left == null && node.right == null) {
            return null;
        } else if (value < node.value) {
            node = deleteRecursive(node.left, value);
        } else if (value > node.value) {
            node = deleteRecursive(node.right, value);
        } else {
            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node smallest = getSmallest(node.right);
                node.value = smallest.value;
                node.right = deleteRecursive(node.right, smallest.value);
            }
        }
        return node;
    }

    private Node getSmallest(Node node) {
        if (node.left != null) {
            return getSmallest(node.left);
        }
        return node;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTreeDS bst = new BinarySearchTreeDS();
        bst.insert(10);
        bst.insert(5);
        bst.insert(12);
        bst.insert(6);
        bst.insert(4);
        System.out.println("done");
    }
}
