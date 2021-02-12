package question.programmers.level1;

// 3진법 뒤집기
public class PG68935 {
    public static void main(String[] args) {
        int[] tests = {45, 125};

        PG68935 pg68935 = new PG68935();
        for(int n : tests) {
            int answer = pg68935.solution(n);
            System.out.println(answer);
        }
    }

    public int solution(int n) {
        int val = n;
        String convert = "";

        while(val/3 > 0) {
            convert += (val%3);
            val = val/3;
        }

        convert += val;

        int answer = 0;
        for(int i=0; i<convert.length(); i++) {
            answer = (3*answer) + Integer.parseInt(String.valueOf(convert.charAt(i)));
        }

        return answer;
    }
}
