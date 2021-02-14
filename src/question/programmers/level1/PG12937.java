package question.programmers.level1;

// 짝수와 홀수
public class PG12937 {
    public static void main(String[] args) {
        int[] nums = {3, 4};

        PG12937 pg12937 = new PG12937();
        for(int num : nums) {
            String answer = pg12937.solution(num);
            System.out.println(answer);
        }
    }

    public String solution(int num) {
        if(num % 2 == 0) {
            return "Even";
        }
        else {
            return "Odd";
        }
    }
}
