package question.programmers.level1;

import java.util.Arrays;

// 정수 내림차순으로 배치하기
public class PG12933 {
    public static void main(String[] args) {
        long n = 118372;

        PG12933 pg12933 = new PG12933();
        long answer = pg12933.solution(n);
        System.out.println(answer);
    }

    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        for(int i=chars.length-1; i>=0; i--) {
            sb.append(chars[i]);
        }
        return Long.parseLong(sb.toString());
    }
}