package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 최대공약수와 최소공배수
public class PG12940 {
    public static void main(String[] args) {
        List<int[]> tests = new ArrayList<>();
        tests.add(new int[]{3, 12});
        tests.add(new int[]{2, 5});
        tests.add(new int[]{10, 75});

        PG12940 pg12940 = new PG12940();
        for(int[] test : tests) {
//            int[] answer = pg12940.solution(test[0], test[1]);
            int[] answer = pg12940.solution2(test[0], test[1]);
            Arrays.stream(answer).forEach(v -> System.out.print(v + " "));
            System.out.println();
        }
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        //최소값 지정
        int min = Math.min(n, m);

        for(int i=min; i>0; i--) {
            if(n % i == 0 && m % i == 0) {
                answer[0] = i;          // 최대공약수
                answer[1] = (m*n) / i;  // 최소공배수 = 최대공배수 / 최대공약수
                break;
            }
        }

        return answer;
    }

    public int[] solution2(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = (n*m) / answer[0];

        return answer;
    }

    //유클리드 호제법
    private int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }

        return gcd(m, n%m);
    }
}