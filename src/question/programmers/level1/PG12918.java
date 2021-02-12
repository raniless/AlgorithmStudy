package question.programmers.level1;

// 문자열 다루기 기본
public class PG12918 {
    public static void main(String[] args) {
        String[] tests = {"a234", "1234"};

        PG12918 pg12918 = new PG12918();
        for(String s : tests) {
            boolean answer = pg12918.solution(s);
            System.out.println(answer);
        }
    }

    public boolean solution(String s) {
        for(int i=0 ; i<s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))) {
                return false;
            }
        }

        if(s.length() != 4 && s.length() != 6) {
            return false;
        }

        return true;
    }
}
