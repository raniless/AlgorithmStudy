package question.leetcode.medium.range1to100;

import java.util.ArrayList;
import java.util.List;

// Combination Sum
//  - https://leetcode.com/problems/combination-sum/
//  - ref : https://bcp0109.tistory.com/entry/Combination-Sum-Java
public class LP39 {
    public static void main(String[] args) {
        List<LP39Tests> tests = new ArrayList<>();
        tests.add(new LP39Tests(new int[]{2,3,5}, 8));
        tests.add(new LP39Tests(new int[]{2}, 1));
        tests.add(new LP39Tests(new int[]{1}, 1));
        tests.add(new LP39Tests(new int[]{1}, 2));

        LP39 lp39 = new LP39();
        for(LP39Tests test : tests) {
            List<List<Integer>> answer = lp39.combinationSum(test.getCandidates(), test.getTarget());
            System.out.println(answer);
        }
    }

    // Solution : DFS
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0; i<candidates.length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(candidates[i]);
            dfs(candidates, i, 1, target-candidates[i], path, answer);
        }

        return answer;
    }

    private void dfs(int[] candidates, int start, int size, int target, List<Integer> path, List<List<Integer>> answer) {
        if(target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(candidates, i, size+1, target-candidates[i], path, answer);
                path.remove(size);
            }
        }
    }

    static class LP39Tests {
        private int[] candidates;
        private int target;

        public LP39Tests(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
        }

        public int[] getCandidates() {
            return candidates;
        }

        public void setCandidates(int[] candidates) {
            this.candidates = candidates;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }
    }
}