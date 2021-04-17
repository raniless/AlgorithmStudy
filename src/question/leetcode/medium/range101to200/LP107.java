package question.leetcode.medium.range101to200;

import question.leetcode.util.LeetCodeUtil;
import question.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Binary Tree Level Order Traversal II
//  - https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class LP107 {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = LeetCodeUtil.makeTreeNode(input);

        LP107 lp107 = new LP107();
        List<List<Integer>> result = lp107.levelOrderBottom(root);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();

        addLevelOrderList(levelOrderList, root, 1);
        return levelOrderList;
    }

    private void addLevelOrderList(List<List<Integer>> levelOrderList, TreeNode node, int level) {
        if(node == null) {
            return;
        }

        if(levelOrderList.size() >= level) {
            levelOrderList.get(levelOrderList.size()-level).add(node.val);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            levelOrderList.add(0, list);
        }

        addLevelOrderList(levelOrderList, node.left, level+1);
        addLevelOrderList(levelOrderList, node.right, level+1);
    }
}