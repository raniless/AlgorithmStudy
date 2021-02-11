package question.programmers.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 모의고사
public class PG42840 {
    public static void main(String[] args) {
        int[][] tests = new int[][]{{1,2,3,4,5}, {1,3,2,4,2}};

        PG42840 pg42840 = new PG42840();
        for(int[] answers : tests) {
            int[] answer = pg42840.solution(answers);
            for(int value : answer) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public int[] solution(int[] answers) {
        int[] supo1Pattern = new int[]{1, 2, 3, 4, 5};
        int[] supo2Pattern = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3Pattern = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int supo1Cnt = 0;
        int supo2Cnt = 0;
        int supo3Cnt = 0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == supo1Pattern[i % supo1Pattern.length]) {
                supo1Cnt++;
            }
            if(answers[i] == supo2Pattern[i % supo2Pattern.length]) {
                supo2Cnt++;
            }
            if(answers[i] == supo3Pattern[i % supo3Pattern.length]) {
                supo3Cnt++;
            }
        }

        int maxCnt = Math.max(Math.max(supo1Cnt, supo2Cnt), supo3Cnt);
        List<Integer> list = new ArrayList<>();
        if(maxCnt == supo1Cnt) {
            list.add(1);
        }
        if(maxCnt == supo2Cnt) {
            list.add(2);
        }
        if(maxCnt == supo3Cnt) {
            list.add(3);
        }
        list.sort(Comparator.naturalOrder());

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}