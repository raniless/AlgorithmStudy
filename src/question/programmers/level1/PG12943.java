package question.programmers.level1;

// 콜라츠 추측
public class PG12943 {
    public static void main(String[] args) {
        int[] tests = {6, 16, 626331};

        PG12943 pg12943 = new PG12943();
        for(int num : tests) {
            int answer = pg12943.solution(num);
            System.out.println(answer);
        }
    }

    public int solution(int num) {
        int answer = 0;
        while(num != 1 && answer < 501) {
            if(num % 2 == 0) {
                num /= 2;
            }
            else if(num % 2 == 1) {
                num = num*3 + 1;
            }

            answer++;
        }

        return answer == 501 ? -1 : answer;
    }
}
