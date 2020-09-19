package question.leetcode.easy.range101to200;

import question.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

// Intersection of Two Linked Lists
public class LP160 {
    public static void main(String[] args) {

    }

    //Two Pointer
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA != null) ? pA.next : headB;
            pB = (pB != null) ? pB.next : headA;
        }

        return pA;
    }

    /*
    //Hash Set
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> checkSet = new HashSet<>();

        ListNode currNode = headA;
        while(currNode != null) {
            checkSet.add(currNode);
            currNode = currNode.next;
        }

        currNode = headB;
        while(currNode != null) {
            if(checkSet.contains(currNode)) {
                return currNode;
            }

            currNode = currNode.next;
        }

        return null;
    }
    */
}