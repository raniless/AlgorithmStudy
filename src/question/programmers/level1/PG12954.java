package question.programmers.level1;

import java.util.Arrays;

// x만큼 간격이 있는 n개의 숫자
public class PG12954 {
    public static void main(String[] args) {
        int[][] tests = {{2,5}, {4,5}, {-4,2}};

        PG12954 pg12954 = new PG12954();
        for(int[] test : tests) {
            long[] answer = pg12954.solution(test[0], test[1]);
            System.out.println(Arrays.toString(answer));
        }
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i=0; i<n; i++) {
            answer[i] = (long)x * (long)(i+1);
        }

        return answer;
    }
}
