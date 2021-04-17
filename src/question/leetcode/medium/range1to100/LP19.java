package question.leetcode.medium.range1to100;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

// Remove Nth Node From End of List
//  - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class LP19 {
    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4,5};
        ListNode head = LeetCodeUtil.makeListNode(values);
        int n = 2;

        LP19 lp19 = new LP19();
        ListNode result = lp19.removeNthFromEnd(head, n);
        LeetCodeUtil.printListNode(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode preNode = dummy;
        ListNode checkNode = dummy;

        for(int i=1; i<=n+1; i++) {
            checkNode = checkNode.next;
        }

        while(checkNode != null) {
            preNode = preNode.next;
            checkNode = checkNode.next;
        }

        preNode.next = preNode.next.next;

        return dummy.next;
    }
}