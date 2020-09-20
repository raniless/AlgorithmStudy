package question.leetcode.medium.range1to100;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

//
public class LP24 {
    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4};
//        int[] values = new int[]{1};
        ListNode head = LeetCodeUtil.makeListNode(values);

        LP24 lp24 = new LP24();
        ListNode result = lp24.swapPairs(head);
        LeetCodeUtil.printListNode(result);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode point = dummy;
        while(point.next != null && point.next.next != null) {
            ListNode first = point.next;
            ListNode second = point.next.next;

            first.next = second.next;
            second.next = first;

            point.next = second;
            point = first;
        }

        return dummy.next;
    }

    /*
    //재귀
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode node = head.next;
        ListNode nextHead = node.next;

        node.next = head;
        head.next = swapPairs(nextHead);
        head = node;

        return head;
    }
    */
}