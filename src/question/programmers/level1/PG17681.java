package question.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [1차] 비밀지도
public class PG17681 {
    public static void main(String[] args) {
        List<PG17681Test> tests = new ArrayList<>();
        tests.add(new PG17681Test(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
        tests.add(new PG17681Test(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}));

        PG17681 pg17681 = new PG17681();
        for(PG17681Test test : tests) {
            String[] answer = pg17681.solution(test.getN(), test.getArr1(), test.getArr2());
            System.out.println(Arrays.toString(answer));
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

            while(binary.length() < n) {
                binary = "0" + binary;
            }
            binary = binary.replace("1", "#").replace("0", " ");

            answer[i] = binary;
        }

        return answer;
    }

    static class PG17681Test {
        private int n;
        private int[] arr1;
        private int[] arr2;

        public PG17681Test(int n, int[] arr1, int[] arr2) {
            this.n = n;
            this.arr1 = arr1;
            this.arr2 = arr2;
        }

        public int getN() {
            return n;
        }

        public int[] getArr1() {
            return arr1;
        }

        public int[] getArr2() {
            return arr2;
        }
    }
}