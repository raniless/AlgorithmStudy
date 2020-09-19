package question.leetcode.medium.range1to100;

import java.util.ArrayList;
import java.util.List;

// Generate Parentheses
public class LP22 {
    //좀 더 학습이 필요
    public static void main(String[] args) {
        int n = 3;

        LP22 lp22 = new LP22();
        List<String> result = lp22.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generateParenthesis(answer, "", 0, 0, n);
        return answer;
    }

    private void generateParenthesis(List<String> answer, String value, int open, int close, int max) {
        if(value.length() == max*2) {
            answer.add(value);
            return;
        }

        if(open < max) {
            generateParenthesis(answer, value+"(", open+1, close, max);
        }
        if(close < open) {
            generateParenthesis(answer, value+")", open, close+1, max);
        }
    }
}