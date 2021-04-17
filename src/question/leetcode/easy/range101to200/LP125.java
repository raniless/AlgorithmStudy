package question.leetcode.easy.range101to200;

// Valid Palindrome
// - https://leetcode.com/problems/valid-palindrome/
public class LP125 {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = ".,";
        String s = "0P";
        LP125 lp125 = new LP125();
        boolean result = lp125.isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if(!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(Character ch) {
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }
}