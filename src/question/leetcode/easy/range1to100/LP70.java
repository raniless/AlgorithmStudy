package question.leetcode.easy.range1to100;

//Climbing Stairs
public class LP70 {
    public static void main(String[] args) {
        int n = 2;

        LP70 lp70 = new LP70();
        int result = lp70.climbStairs(n);
        System.out.println(result);
    }

    //피보나치
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }

        int first = 1;
        int second = 2;

        for(int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}