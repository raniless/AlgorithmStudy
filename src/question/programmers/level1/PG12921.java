package question.programmers.level1;

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
        // 기법 : 에라토스테네스의 체
        // 소수를 찾기위한 boolean 배열 (소수 = false, 소수아님 = true )
        // 인덱스번호와 숫자의 순서를 맞추기 위해 n+1길이 선언
        boolean[] prime= new boolean[n+1];

        // 인덱스 0번째와 1번째는 소수아님 처리 (0, 1)
        prime[0] = true;
        prime[1] = true;

        // n은 i의 제곱근보다 커야한다.
        for(int i=2; i*i<=n; i++) {
            // i의 제곱근의 인덱스번호에 해당하는 숫자를 소수아님 처리
            // ex) i=2 (소수) -> i*i = 4 (소수아님)
            // j에 i를 더한 제곱근이 n만큼 작을 때 반복적으로 나오는 인덱스 번호를 소수아님 처리
            for(int j=i*i; j<=n; j+=i) {
                prime[j] = true;
            }
        }

        // prime 배열 내의 false(소수) 표시를 찾고
        int answer = 0;
        for(int i=0; i<=n; i++) {
            if(prime[i] == false) {
                // answer에 +1
                answer +=1;
            }
        }

        return answer;
    }
}
