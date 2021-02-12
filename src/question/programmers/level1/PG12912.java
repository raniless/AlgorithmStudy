package question.programmers.level1;

// 두 정수 사이의 합
public class PG12912 {
    public static void main(String[] args) {
        int[][] tests = {{3,5}, {3,3}, {5,3}};

        PG12912 pg12912 = new PG12912();
        for(int[] test : tests) {
            long answer = pg12912.solution(test[0], test[1]);
            System.out.println(answer);
        }
    }

    public long solution(int a, int b) {
        if(a == b) {
            return a;
        }

        long longA = Long.parseLong(String.valueOf(a));
        long longB = Long.parseLong(String.valueOf(b));

        long start = Math.min(longA, longB);
        long end = Math.max(longA, longB);

        long answer = 0;
        for(long i=start; i<=end; i++) {
            answer += i;
        }

        return answer;
    }
}
