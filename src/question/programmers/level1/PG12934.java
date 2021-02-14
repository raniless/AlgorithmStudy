package question.programmers.level1;

import netscape.javascript.JSUtil;

// 정수 제곱근 판별
public class PG12934 {
    public static void main(String[] args) {
        long[] tests = {121, 3};
        PG12934 pg12934 = new PG12934();
        for(long n : tests) {
//            long answer = pg12934.solution(n);
            long answer = pg12934.solution2(n);
            System.out.println(answer);
        }
    }

    public long solution(long n) {
        double rootSquare = Math.sqrt(n);
        if(rootSquare != (long)rootSquare) {
            return -1;
        }
        else {
            return (long)Math.pow((long)rootSquare+1, 2);
        }
    }

    public long solution2(long n) {
        if(Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long)Math.pow(Math.sqrt(n)+1, 2);
        }

        return -1;
    }
}
