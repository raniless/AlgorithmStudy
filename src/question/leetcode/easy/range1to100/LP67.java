package question.leetcode.easy.range1to100;

//Add Binary
/*
Input: a = "11", b = "1"
Output: "100"

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class LP67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        LP67 lp67 = new LP67();
        String result = lp67.addBinary(a, b);
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        int idxA = a.length()-1;
        int idxB = b.length()-1;

        int overflow = 0;
        String result = "";
        while(idxA >= 0 || idxB >= 0) {
            int bitA = idxA >= 0 ? Character.digit(a.charAt(idxA), 10) : 0;
            int bitB = idxB >= 0 ? Character.digit(b.charAt(idxB), 10) : 0;
            int bitSum = bitA + bitB + overflow;
            overflow = bitSum / 2;
            int mod = bitSum % 2;

            result = mod + result;
            if(idxA >= 0) {
                idxA--;
            }

            if(idxB >= 0) {
                idxB--;
            }
        }

        if(overflow == 1) {
            result = overflow + result;
        }

        return result;
    }
}
