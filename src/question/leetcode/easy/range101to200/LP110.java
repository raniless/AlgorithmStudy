package question.leetcode.easy.range101to200;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

// Balanced Binary Tree
public class LP110 {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{3,9,20,null,null,15,7};
//        Integer[] input = new Integer[]{1,2,2,3,3,null,null,4,4};
        TreeNode root = LeetCodeUtil.makeTreeNode(input);

        LP110 lp110 = new LP110();
        boolean result = lp110.isBalanced(root);
        System.out.println(result);
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        int diff = Math.abs(leftH - rightH);

        //-1 : Unbalanced Tree
        if(leftH == -1 || rightH == -1 || diff > 1) {
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }
}