package question.programmers.level2;

import java.util.PriorityQueue;

// 더 맵게
public class PG42626 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        PG42626 pg42626 = new PG42626();
        int result = pg42626.solution(scoville, K);
        System.out.println(result);
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int val : scoville) {
            pq.offer(val);
        }

        int result = 0;
        while (pq.peek() < K) {
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return
            if(pq.size() == 1) {
                result = -1;
                break;
            }

            pq.offer(pq.poll() + (pq.poll() * 2));
            result++;
        }

        return result;
    }


}
