package question.leetcode.util;

public abstract class LeetCodeUtil {
    public static ListNode makeListNode(int[] values) {
        ListNode dummyHead = new ListNode(0);

        ListNode currNode = dummyHead;
        for(int value : values) {
            currNode = currNode.next = new ListNode(value);
        }

        return dummyHead.next;
    }
}