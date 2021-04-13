package question.leetcode.medium.range1to100;

import java.util.ArrayList;

// Jump Game II
//  - https://leetcode.com/problems/jump-game-ii/
//  - ref : https://bcp0109.tistory.com/entry/LeetCode-Hard-Jump-Game-II-Java
public class LP45 {
    public static void main(String[] args) {
        ArrayList<int[]> tests = new ArrayList<>();
        tests.add(new int[]{2,3,1,1,4});
        tests.add(new int[]{2,3,0,1,4});

        LP45 lp45 = new LP45();
        for(int[] nums : tests) {
            int answer = lp45.jump(nums);
            System.out.println(answer);
        }
    }

    // Solution : Greedy
    public int jump(int[] nums) {
        int count = 0;
        int currMaxPos = 0; // Count 대상 위치
        int nextMaxPos = 0; // currMaxPos 기준 다음 Count 대상 위치

        for(int i=0; i<nums.length-1; i++) {
            nextMaxPos = Math.max(nextMaxPos, i + nums[i]);

            //다음 Max Jump Position에 도달한 경우
            if(i == currMaxPos) {
                count++;
                currMaxPos = nextMaxPos;
            }
        }

        return count;
    }
}
