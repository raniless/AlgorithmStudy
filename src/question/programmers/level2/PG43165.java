package question.programmers.level2;

// 타겟 넘버
public class PG43165 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        PG43165 pg43165 = new PG43165();
        int result = pg43165.solution(numbers, target);
        System.out.println(result);
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    public int dfs(int[] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(numbers, depth+1, sum+numbers[depth], target) + dfs(numbers, depth+1, sum-numbers[depth], target);
    }
}
