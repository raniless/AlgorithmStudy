package question.leetcode.easy.range101to200;

import java.util.ArrayList;
import java.util.List;

// Pascal's Triangle
public class LP118 {
    public static void main(String[] args) {
        int numRows = 5;
        LP118 lp118 = new LP118();
        List<List<Integer>> result = lp118.generate(numRows);

        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        for(int row=0; row<numRows; row++) {
            List<Integer> current = new ArrayList<>();
            for(int col=0; col<=row; col++) {
                if(col == 0 || col == row) {
                    current.add(1);
                }
                else {
                    List<Integer> before = answer.get(row-1);
                    current.add(before.get(col-1) + before.get(col));
                }
            }

            answer.add(current);
        }

        return answer;
    }
}