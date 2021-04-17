package question.leetcode.easy.range101to200;

import question.leetcode.util.TreeNode;

// Convert Sorted Array to Binary Search Tree
//  - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class LP108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};

        LP108 lp108 = new LP108();
        TreeNode result = lp108.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    private TreeNode createBST(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = (left+right) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, left, mid-1);
        root.right = createBST(nums, mid+1, right);

        return root;
    }
}