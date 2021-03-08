package question.programmers.level2;

import java.util.*;

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

    /*
    //Version 1
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        int releaseIdx = 0;
        while(releaseIdx < progresses.length) {
            if(progresses[releaseIdx] < 100) {
                for(int i=releaseIdx; i<progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
            }
            else {
                int cnt = 0;
                while(releaseIdx < progresses.length) {
                    if(progresses[releaseIdx] < 100) {
                        break;
                    }

                    cnt++;
                    releaseIdx++;
                }
                queue.add(cnt);
            }
        }

        int[] answer = new int[queue.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
    */

    // Version 2 - More Fast
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        int workingDays = 1;
        for(int i=0; i<progresses.length; i++) {
            //완료 작업일수 계산
            while(progresses[i] + (speeds[i] * workingDays) < 100) {
                workingDays++;
            }

            //다음 기능부터 완료된 기능 개수 Count
            int releaseCnt = 0;
            while(i < progresses.length) {
                if(progresses[i] + (speeds[i] * workingDays) < 100) {
                    i--;
                    break;
                }

                releaseCnt++;
                i++;
            }

            queue.add(releaseCnt);
        }

        int[] answer = new int[queue.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = queue.poll();
        }

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
