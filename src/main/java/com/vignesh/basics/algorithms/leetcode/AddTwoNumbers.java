package com.vignesh.basics.algorithms.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x +y;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            System.out.println("temp = " + toString(head));
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers app = new AddTwoNumbers();
        ListNode listNode = app.addTwoNumbers(
                toNode(2,4,3),
                toNode(5,6,4));
        String result = toString(listNode);
        System.out.println("result = " + result);
    }

    private static ListNode toNode(int... numbers) {
        ListNode head = null;
        ListNode result = null;
        ListNode last = null;
        for (int i = 0; i < numbers.length; i++) {
            if (result == null) {
                head = new ListNode();
                result = head;
            }
            head.val = numbers[i];
            head.next = new ListNode();
            last = head;
            head = head.next;
        }
        last.next = null;
        return result;
    }

    private static String toString(ListNode n) {
        StringBuilder builder = new StringBuilder();
        while (n != null) {
            builder.append(n.val);
            n = n.next;
        }
        return builder.toString();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
