package com.vignesh.basics.datastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyLinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size = 0;

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public E[] toArray() {
        if (size < 1) {
            return null;
        }
        Object[] arr = new Object[size];
        Node<E> f = first;
        int i = 0;
        while (f != null) {
            arr[i] = f.getItem();
            f = f.next;
            i++;
        }
        return (E[]) arr;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }
    }
}
