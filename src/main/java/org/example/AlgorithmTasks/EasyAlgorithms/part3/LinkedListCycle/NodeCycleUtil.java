package org.example.AlgorithmTasks.EasyAlgorithms.part3.LinkedListCycle;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class NodeCycleUtil {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        if (head.next == null) return false;

        if (head.next.next == null) return false;

        return compareNode(head, head.next.next);
    }

    private static boolean compareNode(ListNode head, ListNode next2Node) {
        if (head.next == null) return false;
        if (next2Node.next == null) return false;
        if (next2Node.next.next == null) return false;

        if (head.next.equals(next2Node.next)) {
            return true;
        } else
            return compareNode(head.next, next2Node.next.next);
    }
}