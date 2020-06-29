package question.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[input]
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0

[output]
1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7

1 2 3 5 8 13
1 2 3 5 8 21
1 2 3 5 8 34
1 2 3 5 13 21
1 2 3 5 13 34
1 2 3 5 21 34
1 2 3 8 13 21
1 2 3 8 13 34
1 2 3 8 21 34
1 2 3 13 21 34
1 2 5 8 13 21
1 2 5 8 13 34
1 2 5 8 21 34
1 2 5 13 21 34
1 2 8 13 21 34
1 3 5 8 13 21
1 3 5 8 13 34
1 3 5 8 21 34
1 3 5 13 21 34
1 3 8 13 21 34
1 5 8 13 21 34
2 3 5 8 13 21
2 3 5 8 13 34
2 3 5 8 21 34
2 3 5 13 21 34
2 3 8 13 21 34
2 5 8 13 21 34
3 5 8 13 21 34

 */
//class Main {
public class P6603 {
    private static int LOTTO_CNT = 6;
    private static int K;
    private static int[] S;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            StringTokenizer st = null;
            while(true) {
                st = new StringTokenizer(br.readLine());
                K = Integer.parseInt(st.nextToken());

                if(K == 0) {
                    break;
                }

                S = new int[K+1];
                check = new boolean[K+1];
                for(int i=1; i<=K; i++) {
                    S[i] = Integer.parseInt(st.nextToken());
                }

                for(int i=1; i<=K-(LOTTO_CNT-1); i++) {
                    check[i] = true;
                    dfs(i+1, 1);
                    check[i] = false;
                }

                System.out.println("");
            }
        }catch (IOException e) {
            throw e;
        }
    }

    private static void dfs(int idx, int cnt) {
        if(cnt == LOTTO_CNT) {
            for(int i=1; i<=K; i++) {
                if(check[i]) {
                    System.out.print(S[i] + " ");
                }
            }
            System.out.println("");
        }

        for(int i=idx; i<=K; i++) {
            check[i] = true;
            dfs(i+1, cnt+1);
            check[i] = false;
        }
    }
}
