package question.programmers.level1;

import java.util.*;

// 두 개 뽑아서 더하기
public class PG68644 {
    public static void main(String[] args) {
        int[][] tests = new int[][]{{2,1,3,4,1}, {5,0,2,7}};

        PG68644 pg68644 = new PG68644();
        for(int[] numbers : tests) {
            int[] answer = pg68644.solution(numbers);

            for(int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1;j<numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
