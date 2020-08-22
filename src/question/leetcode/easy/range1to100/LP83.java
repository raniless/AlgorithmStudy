package question.leetcode.easy.range1to100;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

//Remove Duplicates from Sorted List
public class LP83 {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,2,3,1,1,2,3,5,6,7,8,8,7,1,2,2,2};
        ListNode head = LeetCodeUtil.makeListNode(input);
        LP83 lp83 = new LP83();
        ListNode result = lp83.deleteDuplicates(head);
        LeetCodeUtil.printListNode(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}