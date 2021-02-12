package question.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// 같은 숫자는 싫어
public class PG12906 {
    public static void main(String[] args) {
        int[][] tests = {{1,1,3,3,0,1,1}, {4,4,4,3,3}};

        PG12906 pg12906 = new PG12906();
        for(int[] arr : tests) {
            int[] answer = pg12906.solution(arr);
            for(int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for(int i=1; i<arr.length;i++) {
            if(arr[i-1] != arr[i]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}