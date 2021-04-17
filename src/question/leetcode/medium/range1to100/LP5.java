package question.leetcode.medium.range1to100;

// Longest Palindromic Substring
// - https://leetcode.com/problems/longest-palindromic-substring/
public class LP5 {
    public static void main(String[] args) {
//        String s = "babad";
        String s = "cdabba";

        LP5 lp5 = new LP5();
        String result = lp5.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++) {
            //회문 길이가 홀수인 Case Check
            int len1 = expandAroundCenter(s, i, i);
            //회문 길이가 짝수인 Case Check (ex. abba)
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                //회문 길이가 짝수인경우 center 기준으로 left는 right보다 한 칸 덜 이동
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }
}