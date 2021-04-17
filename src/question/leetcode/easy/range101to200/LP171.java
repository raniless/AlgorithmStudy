package question.leetcode.easy.range101to200;

// Excel Sheet Column Number
//  - https://leetcode.com/problems/excel-sheet-column-number/
public class LP171 {
    public static void main(String[] args) {
        String s = "ZY";

        LP171 lp171 = new LP171();
        int result = lp171.titleToNumber(s);
        System.out.println(result);
    }

    public int titleToNumber(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            result = result * 26 + (c-'A'+1);
        }

        return result;
    }
}