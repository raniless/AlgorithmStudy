package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 평균 구하기
public class PG12944 {
    public static void main(String[] args) {
        List<int[]> tests = new ArrayList<>();
        tests.add(new int[]{1,2,3,4});
        tests.add(new int[]{5,5});

        PG12944 pg12944 = new PG12944();
        for(int[] arr : tests) {
            double answer = pg12944.solution(arr);
            System.out.println(answer);
        }
    }

    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}
