package question.leetcode.easy.range101to200;

import java.util.HashSet;
import java.util.Set;

// Single Number
public class LP136 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        LP136 lp136 = new LP136();
        int result = lp136.singleNumber(nums);
        System.out.println(result);
    }

    /*
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int num : nums) {
            if(set.contains(num)) {
                sum -= num;
                continue;
            }

            set.add(num);
            sum += num;
        }

        return sum;
    }
    */

    public int singleNumber(int[] nums) {
        int answer = 0;
        for(int num : nums) {
            //XOR 연산(같은 수 연산 결과는 0)
            answer ^= num;
        }
        return answer;
    }
}
