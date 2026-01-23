package org.ssh.amen.t2addtwonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode nextNode = result;
        ListNode nextL1 = l1;
        ListNode nextL2 = l2;
        boolean leftover = false;

        while (nextL1 != null && nextL2 != null) {
            ListNode newNode = new ListNode();
            nextNode.next = newNode;
            newNode.val = nextL1.val + nextL2.val;
            if (leftover) {
                newNode.val += 1;
                leftover = false;
            }

            if (newNode.val >= 10) {
                leftover = true;
                newNode.val = newNode.val % 10;
            }
            nextL1 = nextL1.next;
            nextL2 = nextL2.next;
            nextNode = nextNode.next;
        }

        while (nextL2 != null) {
            ListNode newNode = new ListNode();
            nextNode.next = newNode;
            newNode.val =  nextL2.val;
            if (leftover) {
                newNode.val += 1;
                leftover = false;
            }

            if (newNode.val >=10) {
                leftover = true;
                newNode.val = newNode.val % 10;
            }
            nextL2 = nextL2.next;
            nextNode = nextNode.next;
        }
        while (nextL1 != null) {
            ListNode newNode = new ListNode();
            nextNode.next = newNode;
            newNode.val =  nextL1.val;
            if (leftover) {
                newNode.val += 1;
                leftover = false;
            }

            if (newNode.val >= 10) {
                leftover = true;
                newNode.val = newNode.val % 10;
            }
            nextL1 = nextL1.next;
            nextNode = nextNode.next;
        }
        if (leftover) {
            ListNode newNode = new ListNode();
            nextNode.next = newNode;
            newNode.val += 1;
        }

        return result.next;
    }

    public static class ListNode {
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

    public static void main(String[] args) {
        addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        );
        addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))
        );
        addTwoNumbers(
                new ListNode(0),
                new ListNode(0)
        );
    }
}
