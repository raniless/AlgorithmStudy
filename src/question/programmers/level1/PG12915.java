package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 문자열 내 마음대로 정렬하기
public class PG12915 {
    public static void main(String[] args) {
        List<PG12915Test> tests = new ArrayList<>();
        tests.add(new PG12915Test(new String[]{"sun", "bed", "car"}, 1));
        tests.add(new PG12915Test(new String[]{"abce", "abcd", "cdx"}, 2));

        PG12915 pg12915 = new PG12915();
        for(PG12915Test test : tests) {
            String[] answer = pg12915.solution(test.getStrings(), test.getN());
            for(String s : answer) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    public String[] solution(String[] strings, int n) {
        String[] answer = strings;

        Arrays.sort(answer, ((o1, o2) -> {
            if(o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }

            return o1.charAt(n) - o2.charAt(n);
        }));

        return answer;
    }

    static class PG12915Test {
        private String[] strings;
        private int n;

        public PG12915Test(String[] strings, int n) {
            this.strings = strings;
            this.n = n;
        }

        public String[] getStrings() {
            return strings;
        }

        public int getN() {
            return n;
        }
    }
}
