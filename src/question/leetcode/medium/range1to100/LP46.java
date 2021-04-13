package question.leetcode.medium.range1to100;

import java.util.ArrayList;
import java.util.List;

// Permutations
//  - Permutation : 순열
//  - https://leetcode.com/problems/permutations/
//  - ref : https://minhamina.tistory.com/37
public class LP46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LP46 lp46 = new LP46();
        List<List<Integer>> answer = lp46.permute(nums);
        System.out.println(answer);
    }

    // Solution : DFS (순열 알고리즘)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums, 0, answer);
        return answer;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> answer) {
        if(index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            answer.add(list);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, index+1, answer);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    /*
    // Solution : recursion (dfs보다 속도 느림)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            recursion(nums, list, answer);
        }

        return answer;
    }

    public void recursion(int[] nums, List<Integer> list, List<List<Integer>> answer) {
        if(list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                recursion(nums, list, answer);
                list.remove(list.size()-1);
            }
        }
    }
    */
}