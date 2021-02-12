package question.programmers.level1;

// 가운데 글자 가져오기
public class PG12903 {
    public static void main(String[] args) {
        String[] tests = {"abcde", "qwer"};

        PG12903 pg12903 = new PG12903();
        for(String s : tests) {
            String answer = pg12903.solution(s);
            System.out.println(answer);
        }
    }

    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;
        if(len % 2 == 0) {
            return s.substring(mid-1, mid+1);
        }
        else {
            return Character.toString(s.charAt(mid));
        }
    }
}
