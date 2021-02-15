package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 행렬의 덧셈
public class PG12950 {
    public static void main(String[] args) {
        List<int[][]> list1 = new ArrayList<>();
        list1.add(new int[][]{{1,2}, {2,3}});
        list1.add(new int[][]{{1}, {2}});

        List<int[][]> list2 = new ArrayList<>();
        list2.add(new int[][]{{3,4}, {5,6}});
        list2.add(new int[][]{{3}, {4}});

        PG12950 pg12950 = new PG12950();
        for(int i=0; i<list1.size(); i++) {
            int[][] answer = pg12950.solution(list1.get(i), list2.get(i));
            Arrays.stream(answer).forEach(arr -> System.out.print(Arrays.toString(arr)));
            System.out.println();
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
