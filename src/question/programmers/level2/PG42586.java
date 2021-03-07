package question.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//기능개발
public class PG42586 {
    public static void main(String[] args) {
        List<PG42586Test> tests = new ArrayList<>();
        tests.add(new PG42586Test(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        tests.add(new PG42586Test(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));

        PG42586 pg42586 = new PG42586();
        for(PG42586Test test : tests) {
            int[] answer = pg42586.solution(test.getProgresses(), test.getSpeeds());
            System.out.println(Arrays.toString(answer));
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        return answer;
    }

    static class PG42586Test {
        private int[] progresses;
        private int[] speeds;

        public PG42586Test(int[] progresses, int[] speeds) {
            this.progresses = progresses;
            this.speeds = speeds;
        }

        public int[] getProgresses() {
            return progresses;
        }

        public int[] getSpeeds() {
            return speeds;
        }
    }
}
