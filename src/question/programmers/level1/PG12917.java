package question.programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 문자열 내림차순으로 배치하기
public class PG12917 {
    public static void main(String[] args) {
        String s = "Zbcdefg";

        PG12917 pg12917 = new PG12917();
        String answer = pg12917.solution(s);
        System.out.println(answer);
    }

    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new StringBuilder(new String(chars)).reverse().toString();
    }
}
