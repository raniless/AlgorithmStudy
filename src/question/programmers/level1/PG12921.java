package question.programmers.level1;

import java.util.Arrays;

// 소수 찾기
public class PG12921 {
    public static void main(String[] args) {
        int[] tests= {10, 5};

        PG12921 pg12921 = new PG12921();
        for(int n : tests) {
            int answer = pg12921.solution(n);
            System.out.println(answer);
        }
    }

    public int solution(int n) {
        /*
         * 에라토스테네스의 체
         * (https://blog.naver.com/limchung90/221749963747)
         */

        // 소수 Check 배열
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        // 0, 1 소수 x
        prime[0] = false;
        prime[1] = false;

        // n은 i의 제곱근보다 커야한다. (Why? 제곱근이 n보다 크면 i보다 작은 소수에서 이미 Check를 했기 때문)
        for(int i=2; i*i<=n; i++) {
            // i의 제곱근 부터 i의 배수 소수아님 처리
            for(int j=i*i; j<=n; j+=i) {
                prime[j] = false;
            }
        }

        // 소수 Count
        int answer = 0;
        for(int i=0; i<=n; i++) {
            if(prime[i]) {
                answer +=1;
            }
        }

        return answer;
    }
}
