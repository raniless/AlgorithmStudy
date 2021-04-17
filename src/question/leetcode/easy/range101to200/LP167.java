package question.leetcode.easy.range101to200;

import java.util.HashMap;
import java.util.Map;

// Two Sum II - Input array is sorted
//  - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class LP167 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        LP167 lp167 = new LP167();
        int[] result = lp167.twoSum(numbers, target);
        for(int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++) {
            int mod = target - numbers[i];
            if(map.containsKey(mod)) {
                return new int[]{map.get(mod)+1, i+1};
            }
            map.put(numbers[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}