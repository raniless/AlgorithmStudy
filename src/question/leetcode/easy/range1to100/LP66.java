package question.leetcode.easy.range1to100;

// Plus One
//  - https://leetcode.com/problems/plus-one/
public class LP66 {
    public static void main(String[] args) {
//        int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] digits = new int[]{9,9,9,9};
        LP66 lp66 = new LP66();
        int[] result = lp66.plusOne(digits);

        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int idx = digits.length-1;

        int over = 1;
        for(int i=idx; i>=0; i--) {
            if(over == 0) {
                return digits;
            }

            int sum = digits[i] + over;
            over = sum / 10;
            digits[i] = sum % 10;
        }

        if(over == 0) {
            return digits;
        }

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = over;
        return newDigits;
    }
}
