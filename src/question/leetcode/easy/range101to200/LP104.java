package question.leetcode.easy.range101to200;

import question.leetcode.util.TreeNode;

//Maximum Depth of Binary Tree
public class LP104 {
    public static void main(String[] args) {
        String[] input = new String[]{"3","9","20",null,null,"15","7"};
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
