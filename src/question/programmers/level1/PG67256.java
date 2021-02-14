package question.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// 키패드 누르기
public class PG67256 {
    public static void main(String[] args) {
        List<PG67256Test> tests = new ArrayList<>();
        tests.add(new PG67256Test(new int[]{1,3,4,5,8,2,1,4,5,9,5}, "right"));
        tests.add(new PG67256Test(new int[]{7,0,8,2,8,3,1,5,7,6,2}, "left"));
        tests.add(new PG67256Test(new int[]{1,2,3,4,5,6,7,8,9,0}, "right"));

        PG67256 pg67256 = new PG67256();
        for(PG67256Test test : tests) {
            String answer = pg67256.solution(test.getNumbers(), test.getHand());
            System.out.println(answer);
        }
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        return answer;
    }

    static class PG67256Test {
        private int[] numbers;
        private String hand;

        public PG67256Test(int[] numbers, String hand) {
            this.numbers = numbers;
            this.hand = hand;
        }

        public int[] getNumbers() {
            return numbers;
        }

        public String getHand() {
            return hand;
        }
    }
}
