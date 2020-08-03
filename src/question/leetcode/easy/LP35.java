package question.leetcode.easy;

//Search Insert Position
/*
Input: [1,3,5,6], 5
Output: 2

Input: [1,3,5,6], 2
Output: 1

Input: [1,3,5,6], 7
Output: 4

Input: [1,3,5,6], 0
Output: 0
 */
public class LP35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;

        LP35 lp35 = new LP35();
        int result = lp35.searchInsert(nums, target);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        int end = nums.length-1;
        if(nums[0] > target) {
            return 0;
        }

        if(nums[end] < target) {
            return nums.length;
        }

        return findIndex(nums, target, 0, end);
    }

    private int findIndex(int[] nums, int target, int start, int end) {
        System.out.println("target : " + target + " start : " + start +" end : " + end);
        int mid = (start + end) / 2;

        System.out.println("mid : " + mid + " val : " + nums[mid]);
        if(target == nums[mid]) {
            return mid;
        }
        else if(target < nums[mid]) {
            if(target == nums[mid-1]) {
                return mid-1;
            }
            else if(target > nums[mid-1]) {
                return mid;
            }
            else {
                return findIndex(nums, target, 0, mid-1);
            }
        }
        else {
            if(target <= nums[mid+1]) {
                return mid+1;
            }
            else {
                return findIndex(nums, target, mid+1, end);
            }
        }
    }
}
