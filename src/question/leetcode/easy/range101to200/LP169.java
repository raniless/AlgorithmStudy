package question.leetcode.easy.range101to200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LP169 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        LP169 lp169 = new LP169();
        int result = lp169.majorityElement(nums);
        System.out.println(result);
    }

    /*
    //HashMap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = getCountMap(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> getCountMap(int[] nums) {
        HashMap<Integer ,Integer> countMap = new HashMap<>();
        for(int num : nums) {
            if(!countMap.containsKey(num)) {
                countMap.put(num, 1);
            }
            else {
                countMap.put(num, countMap.get(num)+1);
            }
        }

        return countMap;
    }


    //Sorting
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        //무조건 2/N개 이상인 수가 존재하므로 가능
        return nums[nums.length/2];
    }
    */

    //Boyer-Moore Voting Algorithm (추가학습 필요)
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
