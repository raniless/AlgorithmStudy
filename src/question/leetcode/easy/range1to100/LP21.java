package question.leetcode.easy.range1to100;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

//Merge Two Sorted Lists
/*
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class LP21 {
    public static void main(String[] args) {
        int[] values = new int[]{-9, 3};
        int[] values2 = new int[]{5, 7};
        ListNode l1 = LeetCodeUtil.makeListNode(values);
        ListNode l2 = LeetCodeUtil.makeListNode(values2);

        LP21 lp21 = new LP21();
        ListNode result = lp21.mergeTwoLists(l1, l2);
        LeetCodeUtil.printListNode(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currL1 = l1;
        ListNode currL2 = l2;

        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;

        // keyPoint : Pointer
        // 두 노드를 비교해서 둘 중 작은값이 있는 노드의 값을 연결하고 Point를 다음으로 이동
        // 두 노드가 끝날때까지 반복
        while(currL1 != null || currL2 != null) {
            if(currL1 == null) {
                currNode.next = new ListNode(currL2.val);
                currL2 = currL2.next;
            }
            else if(currL2 == null) {
                currNode.next = new ListNode(currL1.val);
                currL1 = currL1.next;
            }
            else {
                if (currL1.val <= currL2.val) {
                    currNode.next = new ListNode(currL1.val);
                    currL1 = currL1.next;
                }
                else {
                    currNode.next = new ListNode(currL2.val);
                    currL2 = currL2.next;
                }
            }

            currNode = currNode.next;
        }

        return dummyHead.next;
    }
}