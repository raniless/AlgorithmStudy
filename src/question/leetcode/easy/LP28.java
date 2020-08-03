package question.leetcode.easy;

//Implement strStr()
public class LP28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        LP28 lp28 = new LP28();
        int result = lp28.strStr(haystack, needle);
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }
}
