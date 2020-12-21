package question.leetcode.easy.range201to300;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.ListNode;

//Reverse Linked List
public class LP206 {
    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4,5};
        ListNode head = LeetCodeUtil.makeListNode(values);
        LeetCodeUtil.printListNode(head);
        LP206 lp206 = new LP206();
        ListNode result = lp206.reverseList(head);
        LeetCodeUtil.printListNode(result);
    }

    /*
    //Iterator
    public ListNode reverseList(ListNode head) {
        //Reverse 할 Next Node(시작점)
        ListNode reverseNext = null;
        //변경할 현재 노드
        ListNode curr = head;
        while(curr != null) {
            //Next Node 임시 저장 (curr이 3이면 4)
            ListNode temp = curr.next;
            //현재 노드의 next를 Reverse Next로 변경 (curr이 3이면 3->4 에서 2<-3으로 변경)
            curr.next = reverseNext;
            //Reverse Next Node를 현재 Node로 변경 (다음 Loop 처리를 위해 Reverse Next를 3으로 변경)
            reverseNext = curr;
            //현재 Node를 Next Node로 변경(curr을 4로 변경)
            curr = temp;
        }

        // 최종 Reverse 된 Node를 Return
        return reverseNext;
    }
    */

    //Recursive
    //Leaf Node 기준으로 순차적으로 Link 방향을 변경하고 Leaf Node를 최종 Return 한다.
    public ListNode reverseList(ListNode head) {
        //Leaf Node Return
        if (head == null || head.next == null) {
            return head;
        }

        //Leaf Node(예제로 치면 5)를 받는다.
        ListNode p = reverseList(head.next);
        //1.Reverse Link를 추가한다. (head가 4이면 4->5 에서 4<->5로 Reverse Link 추가)
        head.next.next = head;
        //2.기존 Link를 제거한다.(head가 4이면 4<->5 에서 4<-5로 기존 Link 제거)
        head.next = null;

        //Leaf Node(예제로 치면 5)를 return 한다.
        return p;
    }
}