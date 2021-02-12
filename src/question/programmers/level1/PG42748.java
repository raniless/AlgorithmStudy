package question.programmers.level1;

import java.util.Arrays;

// K번째수
public class PG42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        PG42748 pg42748 = new PG42748();
        int[] answer = pg42748.solution(array, commands);
        for(int value : answer) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int k = command[2];

            int[] newArray = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(newArray);

            answer[i] = newArray[k-1];
        }

        return answer;
    }
}
