package question.leetcode.easy;

public class LP9 {
    public static void main(String[] args) {
        int x = -121;

        LP9 lp9 = new LP9();
        boolean result = lp9.isPalindrome(x);
    }

    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int num = x;
        int reverse = 0;
        while(num != 0) {
            int mod = num % 10;
            num /= 10;
            reverse = reverse * 10 + mod;
        }

        return x == reverse;
    }
}