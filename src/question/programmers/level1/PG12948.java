package question.programmers.level1;

// 핸드폰 번호 가리기
public class PG12948 {
    public static void main(String[] args) {
        String[] tests = {"01033334444", "027778888"};

        PG12948 pg12948 = new PG12948();
        for(String phone_number : tests) {
            String answer = pg12948.solution(phone_number);
            System.out.println(answer);
        }
    }

    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        for(int i=0; i<sb.length()-4; i++) {
            sb.replace(i, i+1, "*");
        }
        return sb.toString();
    }
}
