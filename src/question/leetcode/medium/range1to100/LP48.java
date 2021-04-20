package question.leetcode.medium.range1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Rotate Image
//  - https://leetcode.com/problems/rotate-image/
public class LP48 {
    public static void main(String[] args) {
        List<LP48Test> tests = new ArrayList<>();
        tests.add(new LP48Test(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        tests.add(new LP48Test(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}));
        LP48 lp48 = new LP48();

        for(LP48Test test : tests) {
            lp48.rotate(test.getMatrix());
            System.out.println("================");
        }
    }

    public void rotate(int[][] matrix) {
        //1. y=x 기준 원점 대칭 swap
        for(int x=0; x<matrix.length; x++) {
            for(int y=0; y<x; y++) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }

        //2. y축 대칭 swap
        for(int x=0; x<matrix.length; x++) {
            int lastIndex = matrix[x].length-1;
            int half = matrix.length/2;

            for(int y=0; y<half; y++) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[x][lastIndex-y];
                matrix[x][lastIndex-y] = temp;
            }
        }

        for(int[] rows : matrix) {
            System.out.println(Arrays.toString(rows));
        }
    }

    static class LP48Test {
        private int[][] matrix;

        public LP48Test(int[][] matrix) {
            this.matrix = matrix;
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }
    }
}