package question.programmers.level1;

// 수박수박수박수박수박수?
public class PG12922 {
    public static void main(String[] args) {
        int[] tests = {3, 4};

        PG12922 pg12922 = new PG12922();
        for(int n : tests) {
            String answer = pg12922.solution(n);
            System.out.println(answer);
        }
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n/2; i++) {
            sb.append("수박");
        }

        if(n % 2 != 0) {
            sb.append("수");
        }

        return sb.toString();
    }
}
