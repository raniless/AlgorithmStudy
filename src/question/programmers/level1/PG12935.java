package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 제일 작은 수 제거하기
public class PG12935 {
    public static void main(String[] args) {
        List<int[]> tests = new ArrayList<>();
        tests.add(new int[]{4,3,2,1});
        tests.add(new int[]{10});

        PG12935 pg12935 = new PG12935();
        for(int[] arr : tests) {
            int[] answer = pg12935.solution(arr);
//            int[] answer = pg12935.solution2(arr);
            Arrays.stream(answer).forEach(v -> System.out.print(v + " "));
            System.out.println();
        }
    }

    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[]{-1};
        }

        int minVal = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(v -> v != minVal).toArray();
    }

    public int[] solution2(int[] arr) {
        if(arr.length == 1) {
            return new int[]{-1};
        }

        int minVal = Arrays.stream(arr).min().getAsInt();

        int[] answer = new int[arr.length-1];
        int idx= 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == minVal) {
                continue;
            }

            answer[idx++] = arr[i];
        }

        return answer;
    }
}
