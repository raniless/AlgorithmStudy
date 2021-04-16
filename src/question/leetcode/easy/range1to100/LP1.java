package question.leetcode.easy.range1to100;

import java.util.HashMap;
import java.util.Map;

// Two Sum
//  - https://leetcode.com/problems/two-sum/
public class LP1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        LP1 LP1 = new LP1();
        int[] answer = LP1.twoSum(nums, target);
        System.out.println(answer);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int mod = target - nums[i];
            if(map.containsKey(mod)) {
                return new int[]{map.get(mod), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
