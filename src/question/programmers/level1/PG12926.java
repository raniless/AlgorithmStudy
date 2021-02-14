package question.programmers.level1;

// 시저 암호
public class PG12926 {
    public static void main(String[] args) {
        String[] s = {"AB", "z", "a B z"};
        int[] n = {1 ,1 ,4};

        PG12926 pg12926 = new PG12926();
        for(int i=0; i<s.length; i++) {
            String answer = pg12926.solution(s[i], n[i]);
            System.out.println(answer);
        }
    }

    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer(s);

        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);

            if(Character.isAlphabetic(ch)) {
                char charA = 'a';
                if(Character.isUpperCase(ch)) {
                    charA = 'A';
                }

                char caesarCode = (char) ((ch - charA + n) % 26 + charA);
                sb.replace(i, i + 1, String.valueOf(caesarCode));
            }
        }

        return sb.toString();
    }
}
