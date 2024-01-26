package org.learing.gs;

import java.util.LinkedList;

public class ReverseLinkedListInGroups {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseInGroups(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        LinkedList<ListNode> group = new LinkedList<>();

        ListNode newHead = null;
        ListNode current = head;
        ListNode tail = null;

        while (current != null) {
            int count = 0;

            while (count < k && current != null) {
                group.addFirst(current);
                current = current.next;
                count++;
            }

            if (tail == null) {
                newHead = group.peekFirst();
            } else {
                tail.next = group.peekFirst();
            }

            tail = group.peekLast();
            group.clear();
        }

        if (tail != null) {
            tail.next = null;
        }

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0
        ListNode head = new ListNode(1);
        head.next = new ListNode(9);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(6);

        // Reverse the linked list in groups of size 2
        int groupSize = 2;
        ListNode reversedHead = reverseInGroups(head, groupSize);

        // Print the reversed linked list
        System.out.println("Reversed Linked List in Groups:");
        printList(reversedHead);
    }
}