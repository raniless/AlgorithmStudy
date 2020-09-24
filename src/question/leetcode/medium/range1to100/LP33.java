package question.leetcode.medium.range1to100;

public class LP33 {
    public static void main(String[] args) {
        //result : 4
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int target = 0;

        //result : -1
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int target = 3;

        //result : 0
//        int[] nums = new int[]{5,1,3};
//        int target = 5;

        //result : 4
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        int target = 8;

        LP33 lp33 = new LP33();
        int result = lp33.search(nums, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                //mid가 target보다 크지만 left를 옮겨야 하는 경우
                if(nums[mid] > nums[right] && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                //mid가 target보다 작지만 right를 옮겨야 하는 경우
                if(nums[mid] < nums[left] && target >= nums[left]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}