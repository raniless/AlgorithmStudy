package question.programmers.level1;

// 약수의 합
public class PG12928 {
    public static void main(String[] args) {
        int[] tests = {12, 5};

        PG12928 pg12928 = new PG12928();
        for(int n : tests) {
            int answer = pg12928.solution(n);
            System.out.println(answer);
        }
    }

    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
