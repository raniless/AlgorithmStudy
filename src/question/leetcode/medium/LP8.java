package question.leetcode.medium;

import java.text.NumberFormat;

//String to Integer (atoi)
public class LP8 {
    public static void main(String[] args) {
//        String str = "4193 with words";
//        String str = "42";
//        String str = "   -42";
//        String str = "words and 987";
//        String str = "-91283472332";
        String str = "3.14159";
        LP8 lp8 = new LP8();
        int result = lp8.myAtoi(str);
        System.out.println(result);
    }

    public int myAtoi(String str) {
        //1.Trim
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }

        //부호 Check 및 시작위치 설정
        int start = 0;
        int sign = 1;
        char firstCh = str.charAt(0);
        if('+' == firstCh || '-' == firstCh) {
            start++;
            if('-' == firstCh) {
                sign = -1;
            }
        }

        int result = 0;
        for(int i=start; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(!Character.isDigit(ch)) {
                break;
            }

            int digit = Character.digit(ch, 10);
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
        }

        return sign * result;
    }
}