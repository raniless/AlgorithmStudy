package question.leetcode.easy;

//Maximum Subarray
/*
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class LP53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        LP53 lp53 = new LP53();
        int result = lp53.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxValue = nums[0];

        for(int i=1; i< nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            maxValue = Math.max(maxValue, dp[i]);
        }

        return maxValue;
    }
}