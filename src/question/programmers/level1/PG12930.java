package question.programmers.level1;

// 이상한 문자 만들기
public class PG12930 {
    public static void main(String[] args) {
        String s = "try hello world";

        PG12930 pg12930 = new PG12930();
        String answer = pg12930.solution(s);
        System.out.println(answer);
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int idx = 0;
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == ' ') {
                idx = 0;
                continue;
            }

            if(idx % 2 == 0) {
                sb.replace(i, i+1, String.valueOf(Character.toUpperCase(sb.charAt(i))));
            }
            else {
                sb.replace(i, i+1, String.valueOf(Character.toLowerCase(sb.charAt(i))));
            }

            idx++;
        }

        return sb.toString();
    }
}
