package question.programmers.level1;

// 하샤드 수
public class PG12947 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 11, 13};

        PG12947 pg12947 = new PG12947();
        for(int x : arr) {
            boolean answer = pg12947.solution(x);
            System.out.println(answer);
        }
    }

    public boolean solution(int x) {
        String str = String.valueOf(x);

        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return x % sum == 0;
    }
}
