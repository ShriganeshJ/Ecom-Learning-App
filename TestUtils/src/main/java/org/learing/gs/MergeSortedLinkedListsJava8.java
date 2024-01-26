package org.learing.gs;

import java.util.stream.Stream;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLinkedListsJava8 {

    public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        return Stream.concat(
                        getListStream(l1),
                        getListStream(l2))
                .sorted((a, b) -> Integer.compare(a.val, b.val))
                .reduce(null, (acc, node) -> {
                    if (acc == null) {
                        return node;
                    } else {
                        acc.next = node;
                        return node;
                    }
                });
    }

    private static Stream<ListNode> getListStream(ListNode list) {
        return Stream.iterate(list, node -> node != null, node -> node.next);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeSortedLists(l1, l2);

        System.out.println("Merged Sorted List:");
        printList(mergedList);
    }
}