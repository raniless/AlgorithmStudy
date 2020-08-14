package question.codility.lesson.arrays;

import java.util.*;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = new int[]{9,3,9,3,9,7,9};
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int result = oddOccurrencesInArray.solution(A);
        System.out.println(result);
    }

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int value : A) {
            map.compute(value, (k, v) -> v == null ? 1 : ++v);
        }

        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }
}
