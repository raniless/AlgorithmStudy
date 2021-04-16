package question.leetcode.easy.range1to100;

import java.util.ArrayList;
import java.util.List;

// Search Insert Position
//  - https://leetcode.com/problems/search-insert-position/
public class LP35 {
    public static void main(String[] args) {
        List<LP35Test> tests = new ArrayList<>();
        tests.add(new LP35Test(new int[]{1,3,5,6}, 5));
        tests.add(new LP35Test(new int[]{1,3,5,6}, 2));
        tests.add(new LP35Test(new int[]{1,3,5,6}, 7));
        tests.add(new LP35Test(new int[]{1,3,5,6}, 0));

        LP35 lp35 = new LP35();
        for(LP35Test test :tests) {
            int result = lp35.searchInsert(test.getNums(), test.getTarget());
            System.out.println(result);
        }
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

    static class LP35Test {
        private int[] nums;
        private int target;

        public LP35Test(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        public int[] getNums() {
            return nums;
        }

        public void setNums(int[] nums) {
            this.nums = nums;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }
    }
}
