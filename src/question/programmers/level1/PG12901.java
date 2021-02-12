package question.programmers.level1;

// 2016년
public class PG12901 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        PG12901 pg12901 = new PG12901();
        String answer = pg12901.solution(a, b);
        System.out.println(answer);
    }

    public String solution(int a, int b) {
        int[] daysByMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int sum = 0;
        for(int i=1; i<a; i++) {
            sum += daysByMonth[i];
        }
        sum += (b-1) + 5;

        String answer = day[sum % 7];

        return answer;
    }
}
