package question.leetcode.easy.range101to200;

import question.leetcode.util.ListNode;

// Linked List Cycle
public class LP141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        //Two Pointers(Slow and Fast)
        ListNode slow = head;
        ListNode fast = head.next;

        //Cycle이면 결국은 Slow 와 Fast가 만나게 되어 있다.
        while (slow != fast) {
            //Cycle이 아니면 한 쪽이 빨리 끝날것(null) 이다.
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
