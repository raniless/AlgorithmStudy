package question.leetcode.easy;

import sun.reflect.generics.tree.Tree;

import java.util.*;

// Two Sum IV - Input is a BST
/*
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

 */
public class LP653 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 4, 7};
//        int k = 9;
        int k = 28;

        TreeNode root = makeBST(nums);
//        printTreeNode(root);
        LP653 lp653 = new LP653();
        boolean result = lp653.findTarget(root, k);
        System.out.println(result);
    }

    private static TreeNode makeBST(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currNode = root;
        for(int i=1; i<nums.length; i++) {
            if(i % 2 == 0) {
                TreeNode node = new TreeNode(nums[i]);
                queue.offer(node);
                currNode.right = node;
                currNode = queue.poll();
            }
            else {
                TreeNode node = new TreeNode(nums[i]);
                queue.offer(node);
                currNode.left = node;
            }
        }

        return root;
    }

    private static void printTreeNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
//        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int val = node.val;
            int mod = k - val;

//            if(list.contains(mod)) {
//                return true;
//            }
            if(set.contains(mod)) {
                return true;
            }
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }

            set.add(val);
        }

        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
