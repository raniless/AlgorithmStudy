package question.leetcode.util;

import java.util.LinkedList;
import java.util.Optional;
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
                TreeNode leftNode = null;
                if(value != null) {
                    leftNode = new TreeNode(value);
                    treeNode.left = leftNode;
                }

                q.offer(leftNode);
            }

            if(idx < n) {
                Integer value = values[idx++];
                TreeNode rightNode = null;
                if(value != null) {
                    rightNode = new TreeNode(value);
                    treeNode.right = rightNode;
                }

                q.offer(rightNode);
            }
        }

        return root;
    }

    public static void printTreeNode(TreeNode root) {
        if(root == null) {
            return;
        }

        int maxDepth = getMaxDepth(root, 1);
        TreeNodeWrapper rootWrapper = new TreeNodeWrapper(1, root);
        int currDepth = 1;

        Queue<TreeNodeWrapper> queue = new LinkedList();
        queue.offer(rootWrapper);
        while(!queue.isEmpty()){
            TreeNodeWrapper nodeWrapper = queue.poll();
            TreeNode node = nodeWrapper.getNode();
            int nodeDepth = nodeWrapper.getDepth();

            if(currDepth != nodeDepth) {
                currDepth = nodeDepth;
                System.out.println();
            }

            System.out.print((node == null ? "null" : node.val) + "\t");

            if(nodeDepth < maxDepth) {
                if(node == null) {
                    queue.offer(new TreeNodeWrapper(nodeDepth+1, null));
                    queue.offer(new TreeNodeWrapper(nodeDepth+1, null));
                }
                else {
                    queue.offer(new TreeNodeWrapper(nodeDepth+1, node.left));
                    queue.offer(new TreeNodeWrapper(nodeDepth+1, node.right));
                }
            }
        }
    }

    private static int getMaxDepth(TreeNode node, int depth) {
        if(node == null) {
            return depth-1;
        }

        return Math.max(getMaxDepth(node.left, depth+1), getMaxDepth(node.right, depth+1));
    }

    static class TreeNodeWrapper {
        private int depth;
        private TreeNode node;

        public TreeNodeWrapper(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }

        public int getDepth() {
            return depth;
        }

        public TreeNode getNode() {
            return node;
        }
    }
}