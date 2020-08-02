package question.leetcode.medium;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

//Add Two Numbers
public class LP2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4, 3};
        int[] nums2 = new int[]{5, 6, 4};

        ListNode l1 = LeetCodeUtil.makeListNode(nums1);
        ListNode l2 = LeetCodeUtil.makeListNode(nums2);

        LP2 lp2 = new LP2();
        ListNode result = lp2.addTwoNumbers(l1, l2);
        LeetCodeUtil.printListNode(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        int carry = 0;
        ListNode currNode = dummyHead;
        while(currentL1 != null || currentL2 != null) {
            int num1 = currentL1 == null ? 0 : currentL1.val;
            int num2 = currentL2 == null ? 0 : currentL2.val;

            int sum = carry + num1 + num2;
            carry = sum / 10;
            int mod = sum % 10;

            currNode.next = new ListNode(mod);
            currNode = currNode.next;

            if(currentL1 != null) {
                currentL1 = currentL1.next;
            }

            if(currentL2 != null) {
                currentL2 = currentL2.next;
            }
        }

        if(carry > 0) {
            currNode.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}