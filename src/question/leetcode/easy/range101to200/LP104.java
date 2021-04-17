package question.leetcode.easy.range101to200;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

// Maximum Depth of Binary Tree
//  - https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class LP104 {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{3, 9, 29, null, null, 15, 7};
        TreeNode root = LeetCodeUtil.makeTreeNode(input);

        LP104 lp104 = new LP104();
        int result = lp104.maxDepth(root);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode target, int depth) {
        if(target == null) {
            return depth;
        }

        return Math.max(maxDepth(target.left, depth+1), maxDepth(target.right, depth+1));
    }
}
