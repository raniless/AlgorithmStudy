package question.leetcode.easy.range1to100;

// Longest Common Prefix
// - https://leetcode.com/problems/longest-common-prefix/
public class LP14 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
        LP14 lp14 = new LP14();
        String result = lp14.longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        int minLen = Integer.MAX_VALUE;
        for(String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        String baseStr = strs[0];
        int idx = 0;
        for(int i=0; i<minLen; i++) {
            char baseCh = baseStr.charAt(i);
            boolean diff = false;
            for(int j=1; j<strs.length; j++) {
                char compareCh = strs[j].charAt(i);
                if(baseCh != compareCh) {
                    diff = true;
                    break;
                }
            }

            if(diff) {
                break;
            }

            idx++;
        }

        return baseStr.substring(0, idx);
    }
}