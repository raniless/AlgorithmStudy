package question.programmers.level1;

import java.util.Arrays;

// 자연수 뒤집어 배열로 만들기
public class PG12932 {
    public static void main(String[] args) {
        long n = 12345;

        PG12932 pg12932 = new PG12932();
//        int[] answer = pg12932.solution(n);
        int[] answer = pg12932.solution2(n);

        Arrays.stream(answer).forEach(val -> System.out.print(val + " "));
        System.out.println();
    }

    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        String reverse = sb.reverse().toString();
        int[] answer = new int[reverse.length()];
        for(int i=0; i<reverse.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
        }

        return answer;
    }

    public int[] solution2(long n) {
        String s = Long.toString(n);

        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            answer[i] = (int)(n%10);
            n /= 10;
        }

        return answer;
    }
}
