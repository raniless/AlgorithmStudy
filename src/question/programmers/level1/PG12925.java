package question.programmers.level1;

// 문자열을 정수로 바꾸기
public class PG12925 {
    public static void main(String[] args) {
        String[] tests = {"1234", "-1234"};

        PG12925 pg12925 = new PG12925();
        for(String s : tests) {
            int answer = pg12925.solution(s);
            System.out.println(answer);
        }
    }

    public int solution(String s) {
        String temp = s;

        int sign = 1;
        switch(s.charAt(0)) {
            case '+' :
                temp = temp.substring(1);
                break;
            case '-' :
                temp = temp.substring(1);
                sign *= -1;
                break;
        }

        return Integer.parseInt(temp) * sign;
    }
}
