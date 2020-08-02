package question.leetcode.easy;

import jdk.nashorn.internal.ir.LiteralNode;
import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

//Remove Linked List Elements
/*
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class LP203 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,6,3,4,5,6};
        ListNode head = LeetCodeUtil.makeListNode(nums);
        LeetCodeUtil.printListNode(head);
        int val = 6;

        LP203 lp203 = new LP203();
        ListNode result = lp203.removeElements(head, val);
        LeetCodeUtil.printListNode(result);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode targetNode = dummyHead;
        ListNode currNode = head;
        while(currNode != null) {
            if(currNode.val != val) {
                targetNode.next = new ListNode(currNode.val);
                targetNode = targetNode.next;
            }
            currNode = currNode.next;
        }

        return dummyHead.next;
    }
}
