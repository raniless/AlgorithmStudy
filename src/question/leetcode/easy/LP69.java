package question.leetcode.easy;

public class LP69 {
    public static void main(String[] args) {
        int x = 8;
        LP69 lp69 = new LP69();
        int sqrt = lp69.mySqrt(8);
        System.out.println(sqrt);
    }

    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}