package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 예산
public class PG12982 {
    public static void main(String[] args) {
        List<PG12982Test> tests = new ArrayList<>();
        tests.add(new PG12982Test(new int[]{1,3,2,5,4}, 9));
        tests.add(new PG12982Test(new int[]{2,2,3,3}, 10));

        PG12982 pg12982 = new PG12982();
        for(PG12982Test test : tests) {
            int answer = pg12982.solution(test.getD(), test.getBudget());
            System.out.println(answer);
        }
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int answer = 0;
        for(int i=0; i<d.length; i++) {
            if(d[i] > budget) {
                break;
            }

            budget -= d[i];
            answer++;
        }

        return answer;
    }

    static class PG12982Test {
        private int[] d;
        private int budget;

        public PG12982Test(int[] d, int budget) {
            this.d = d;
            this.budget = budget;
        }

        public int[] getD() {
            return d;
        }

        public int getBudget() {
            return budget;
        }
    }
}
