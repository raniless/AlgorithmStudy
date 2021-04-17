package question.leetcode.easy.range101to200;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

// Path Sum
// - https://leetcode.com/problems/path-sum/
public class LP112 {
    public static void main(String[] args) {
//        Integer[] input = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        Integer[] input = new Integer[]{};
        TreeNode root = LeetCodeUtil.makeTreeNode(input);
        int sum = 22;

        LP112 lp112 = new LP112();
        boolean result = lp112.hasPathSum(root, sum);
        System.out.println(result);
    }

    //훨씬 간결한 로직
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return (sum - root.val) == 0;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /*
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode node, int sum, int subSum) {
        if (node.left == null && node.right == null) {
            return subSum + node.val == sum;
        }

        if (node.left == null) {
            return hasPathSum(node.right, sum, subSum + node.val);
        }
        if (node.right == null) {
            return hasPathSum(node.left, sum, subSum + node.val);
        }

        if (hasPathSum(node.left, sum, subSum + node.val)) {
            return true;
        }

        if (hasPathSum(node.right, sum, subSum + node.val)) {
            return true;
        }

        return false;
    }
    */


}
