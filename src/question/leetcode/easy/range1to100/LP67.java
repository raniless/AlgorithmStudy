package question.leetcode.easy.range1to100;

import java.util.ArrayList;
import java.util.List;

// Add Binary
//  - https://leetcode.com/problems/add-binary/
public class LP67 {
    public static void main(String[] args) {
        List<LP67Test> tests = new ArrayList<>();
        tests.add(new LP67Test("11", "1"));
        tests.add(new LP67Test("1010", "1011"));

        LP67 lp67 = new LP67();
        for(LP67Test test : tests) {
            String result = lp67.addBinary(test.getA(), test.getB());
            System.out.println(result);
        }
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

    static class LP67Test {
        private String a;
        private String b;

        public LP67Test(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
