package question.leetcode.easy;

//Reverse Integer

/*
[ex1]
Input: 123
Output: 321

[ex2]
Input: -123
Output: -321

[ex3]
Input: 120
Output: 21
 */
public class LP7 {
    public static void main(String[] args) {
        int x = -123;
        LP7 lp7 = new LP7();
        int reverse = lp7.reverse(x);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        int reverse = 0;
        while(x != 0) {
            int mod = x % 10;
            x /= 10;

            if(reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }

            if(reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && mod < -8)) {
                return 0;
            }
            reverse = reverse * 10 + mod;
        }

        return reverse;
    }
}
