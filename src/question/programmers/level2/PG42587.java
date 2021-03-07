package question.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

// 프린터
public class PG42587 {
    public static void main(String[] args) {
        List<PG42587Test> tests = new ArrayList<>();
        tests.add(new PG42587Test(new int[]{2, 1, 3, 2}, 2));
        tests.add(new PG42587Test(new int[]{1, 1, 9, 1, 1, 1}, 0));

        PG42587 pg42587 = new PG42587();
        for(PG42587Test test : tests) {
            int answer = pg42587.solution(test.getPriorities(), test.getLocation());
            System.out.println(answer);
        }
    }

    public int solution(int[] priorities, int location) {
        List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        q.addAll(list);
        pq.addAll(list);

        int answer = 0;
        while(!q.isEmpty()) {
            int paper = q.poll();
            if(paper == pq.peek()) {
                answer++;
                pq.poll();
                if(location == 0) {
                    break;
                }
            }
            else {
                q.add(paper);
            }

            location--;
            if(location < 0) {
                location = q.size() - 1;
            }
        }

        return answer;
    }

    private static class PG42587Test {
        private int[] priorities;
        int location;

        public PG42587Test(int[] priorities, int location) {
            this.priorities = priorities;
            this.location = location;
        }

        public int[] getPriorities() {
            return priorities;
        }

        public int getLocation() {
            return location;
        }
    }
}
