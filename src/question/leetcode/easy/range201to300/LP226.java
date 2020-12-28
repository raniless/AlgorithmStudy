package question.leetcode.easy.range201to300;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Invert Binary Tree (Invert : 반전시키다)
public class LP226 {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root = LeetCodeUtil.makeTreeNode(values);

        LP226 lp226 = new LP226();
        TreeNode result = lp226.invertTree(root);
        LeetCodeUtil.printTreeNode(result);
    }

    /*
    //Recursive
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;

        return root;
    }
    */

    //Iterative
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}