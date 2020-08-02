package question.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class LP234 {
    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 2, 1};
        ListNode head = makeListNode(values);

        LP234 lp234 = new LP234();
        boolean result = lp234.isPalindrome(head);
        System.out.println(result);
    }

    private static ListNode makeListNode(int[] values) {
        ListNode dummyHead = new ListNode(0);

        ListNode currNode = dummyHead;
        for(int value : values) {
            currNode = currNode.next = new ListNode(value);
        }

        return dummyHead.next;
    }
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> reverseQueue = new LinkedList<>();

        ListNode currNode = head;
        while(currNode != null) {
            queue.offerLast(currNode.val);
            reverseQueue.offerFirst(currNode.val);
            currNode = currNode.next;
        }

        return queue.equals(reverseQueue);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}