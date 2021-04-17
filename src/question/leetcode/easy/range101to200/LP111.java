package question.leetcode.easy.range101to200;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

// Minimum Depth of Binary Tree
// - https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class LP111 {
    public static void main(String[] args) {
//        Integer[] input = new Integer[]{3,9,20,null,null,15,7};
        Integer[] input = new Integer[]{1,2};
        TreeNode root = LeetCodeUtil.makeTreeNode(input);

        LP111 lp111 = new LP111();
        int result = lp111.minDepth(root);
        System.out.println(result);
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return minDepthOfTree(root);
    }

    private int minDepthOfTree(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 1;
        }

        if(node.left == null) {
            return minDepthOfTree(node.right) + 1;
        }
        else if(node.right == null) {
            return minDepthOfTree(node.left) + 1;
        }

        int left = minDepthOfTree(node.left);
        int right = minDepthOfTree(node.right);

        return Math.min(left, right) + 1;
    }
}