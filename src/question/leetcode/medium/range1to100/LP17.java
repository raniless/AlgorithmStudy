package question.leetcode.medium.range1to100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Letter Combinations of a Phone Number
//  - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LP17 {
    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static void main(String[] args) {
        String digits = "234";

        LP17 lp17 = new LP17();
        List<String> result = lp17.letterCombinations(digits);
        System.out.println(result);

    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if(digits.length() > 0) {
            letterCombinations("", digits, 0, answer);
        }

        return answer;
    }

    private void letterCombinations(String combination, String digits, int idx, List<String> answer) {
        if(idx == digits.length()) {
            answer.add(combination);
        }
        else {
            String digit = Character.toString(digits.charAt(idx));
            String letter = phone.get(digit);
            for(int i=0; i<letter.length(); i++) {
                letterCombinations(combination+Character.toString(letter.charAt(i)), digits, idx+1, answer);
            }
        }
    }
}
