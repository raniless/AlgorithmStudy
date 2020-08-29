package question.leetcode.util;

import java.util.LinkedList;
import java.util.Queue;

public abstract class LeetCodeUtil {
    public static ListNode makeListNode(int[] values) {
        ListNode dummyHead = new ListNode(0);

        ListNode currNode = dummyHead;
        for(int value : values) {
            currNode = currNode.next = new ListNode(value);
        }

        return dummyHead.next;
    }

    public static void printListNode(ListNode listNode) {
        ListNode currentNode = listNode;
        while(currentNode != null) {
            System.out.print(currentNode.val + " ");
            if(currentNode != null) {
                currentNode = currentNode.next;
            }
        }
        System.out.println();
    }

    public static TreeNode makeTreeNode(Integer[] values) {
        if(values == null || values.length == 0) {
            return null;
        }

        int n = values.length;
        int idx = 0;
        TreeNode root = new TreeNode(values[idx++]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(idx < n) {
            TreeNode treeNode = q.poll();
            if(idx < n) {
                Integer value = values[idx++];
                if(value != null) {
                    TreeNode leftNode = new TreeNode(value);
                    treeNode.left = leftNode;
                    q.offer(leftNode);
                }
            }
            if(idx < n) {
                Integer value = values[idx++];
                if(value != null) {
                    TreeNode rightNode = new TreeNode(value);
                    treeNode.right = rightNode;
                    q.offer(rightNode);
                }
            }
        }

        return root;
    }
}