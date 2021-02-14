package question.programmers.level1;

// 자릿수 더하기
public class PG12931 {
    public static void main(String[] args) {
        int[] tests = {123, 987};

        PG12931 pg12931 = new PG12931();
        for(int n : tests) {
            int answer = pg12931.solution(n);
            System.out.println(answer);
        }
    }

    public int solution(int n) {
        String s = String.valueOf(n);

        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            answer += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return answer;
    }
}
