package question.programmers.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 나누어 떨어지는 숫자 배열
public class PG12910 {
    public static void main(String[] args) {
        List<PG12910Test> tests = new ArrayList<>();
        tests.add(new PG12910Test(new int[]{5, 9, 7, 10}, 5));
        tests.add(new PG12910Test(new int[]{2, 36, 1, 3}, 1));
        tests.add(new PG12910Test(new int[]{3, 2, 6}, 10));

        PG12910 pg12910 = new PG12910();
        for(PG12910Test test : tests) {
            int[] answer = pg12910.solution(test.getArr(), test.getDivisor());
            for(int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        list.sort(Comparator.naturalOrder());

        if(list.size() == 0) {
            list.add(-1);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static class PG12910Test {
        private int[] arr;
        private int divisor;

        public PG12910Test(int[] arr, int divisor) {
            this.arr = arr;
            this.divisor = divisor;
        }

        public int[] getArr() {
            return arr;
        }

        public int getDivisor() {
            return divisor;
        }
    }
}
