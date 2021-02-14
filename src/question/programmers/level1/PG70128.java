package question.programmers.level1;

// 내적
public class PG70128 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {-1, 0, 1}};
        int[][] b = {{-3, -1, 0, 2}, {1, 0, -1}};

        PG70128 pg70128 = new PG70128();
        for(int i=0; i<a.length; i++) {
            int answer = pg70128.solution(a[i], b[i]);
            System.out.println(answer);
        }
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i<a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
