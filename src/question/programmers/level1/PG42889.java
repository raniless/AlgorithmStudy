package question.programmers.level1;

import java.util.*;

// 실패율
public class PG42889 {
    public static void main(String[] args) {
        List<PG42889Test> tests = new ArrayList<>();
        tests.add(new PG42889Test(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        tests.add(new PG42889Test(4, new int[]{4,4,4,4,4}));

        PG42889 pg42889 = new PG42889();
        for(PG42889Test test : tests) {
            int[] answer = pg42889.solution(test.getN(), test.getStages());
            System.out.println(Arrays.toString(answer));
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] challenge = new int[N+2];
        for(int i=0; i<stages.length; i++) {
            challenge[stages[i]]++;
        }

        int[] total = new int[N+2];
        total[1] = stages.length;
        for(int i=2; i<total.length; i++) {
            total[i] = total[i-1] - challenge[i-1];
        }

        Map<Integer, Double> map = new TreeMap<>();
        for(int i=1; i<=N; i++) {
            map.put(i, (double)challenge[i] / total[i]);
        }

//        for(Map.Entry<Integer, Double> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>();
        list.addAll(map.entrySet());

        list.sort((e1, e2) -> {
            if(e1.getValue() == e2.getValue()) {
                return e1.getKey() - e2.getKey();
            }

            return e2.getValue().compareTo(e1.getValue());
        });

//        for(Map.Entry<Integer, Double> entry : list) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }

    static class PG42889Test {
        private int N;
        private int[] stages;

        public PG42889Test(int n, int[] stages) {
            N = n;
            this.stages = stages;
        }

        public int getN() {
            return N;
        }

        public int[] getStages() {
            return stages;
        }
    }
}
