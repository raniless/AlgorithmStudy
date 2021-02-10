package question.programmers.level1;

import java.util.Arrays;
import java.util.Stack;

// 크레인 인형뽑기 게임
public class PG64061 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[]{1,5,3,5,1,2,1,4};

        PG64061 pg64061 = new PG64061();
        int answer = pg64061.solution(board, moves);
        System.out.println(answer);
    }

    public int solution(int[][] board, int[] moves) {
        //배열 크기
        int N = board.length;

        //위치별 인형 Y Position
        int[] arrToyPos = new int[N];
        Arrays.fill(arrToyPos, N);

        //위치별로 가장 위에있는 인형의 Y Position을 배열에 저장
        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(board[y][x] > 0) {
                    arrToyPos[x] = y;
                    break;
                }
            }
        }

        //인형 담을 바구니
        Stack<Integer> bucket = new Stack<>();
        bucket.push(0); //dummy
        int bombCnt = 0;
        for(int move : moves) {
            //배열 Index에 의한 -1
            move--;

            int toyPos = arrToyPos[move];
            //멈춘 위치에 인형이 없으면 Skip
            if(toyPos == N) {
                 continue;
            }

            int toy = board[toyPos][move];
            int belowToy = bucket.peek();
            //아래 인형과 같으면 사라짐
            if(toy == belowToy) {
                bucket.pop();
                bombCnt++;
            }
            else {
                bucket.push(toy);
            }

            //아래 인형의 위치로 변경
            arrToyPos[move]++;
        }

        return bombCnt * 2;
    }
}
