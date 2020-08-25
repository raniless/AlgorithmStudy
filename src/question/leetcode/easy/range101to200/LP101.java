package question.leetcode.easy.range101to200;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

//Symmetric Tree
public class LP101 {
    public static void main(String[] args) {
        String[] input = new String[]{"1","2","2",null,"3",null,"3"};
        TreeNode root = LeetCodeUtil.makeTreeNode(input);
        LP101 lp101 = new LP101();
        boolean result = lp101.isSymmetric(root);
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
