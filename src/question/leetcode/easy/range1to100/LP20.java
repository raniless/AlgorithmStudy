package question.leetcode.easy.range1to100;

import java.util.*;

//Valid Parentheses
public class LP20 {
    public static void main(String[] args) {
        String s = "{[]}";
        LP20 lp20 = new LP20();
        boolean result = lp20.isValid(s);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(bracketMap.containsKey(ch)) {
                stack.push(bracketMap.get(ch));
            }
            else if(bracketMap.containsValue(ch)) {
                if(stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}