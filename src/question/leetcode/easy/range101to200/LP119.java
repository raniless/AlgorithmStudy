package question.leetcode.easy.range101to200;

import java.util.ArrayList;
import java.util.List;

// Pascal's Triangle II
public class LP119 {
    public static void main(String[] args) {
        int rowIndex = 5;

        LP119 lp119 = new LP119();
        List<Integer> result = lp119.getRow(rowIndex);
        System.out.println(result);
    }

    /*
    public List<Integer> getRow(int rowIndex) {
        List<Integer> before = null;
        List<Integer> current = null;
        for(int row=0; row<=rowIndex; row++) {
            current = new ArrayList<>();
            for(int col=0; col<=row; col++) {
                if(col == 0 || col == row) {
                    current.add(1);
                }
                else {
                    current.add(before.get(col-1) + before.get(col));
                }
            }

            before = current;
        }

        return current;
    }
    */

    //More Efficient Case
    public List<Integer> getRow(int rowIndex) {
        List<Integer> answer = new ArrayList<>();
        answer.add(1);

        for(int i=1; i<=rowIndex; i++) {
            int preVal = 1;

            for(int j=1; j<i; j++) {
                int val = answer.get(j);
                answer.set(j, preVal+val);
                preVal = val;
            }
            answer.add(1);
        }

        return answer;
    }
}