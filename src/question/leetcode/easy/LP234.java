package question.leetcode.easy;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class LP234 {
    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 2, 1};
        ListNode head = LeetCodeUtil.makeListNode(values);

        LP234 lp234 = new LP234();
        boolean result = lp234.isPalindrome(head);
        System.out.println(result);
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
}