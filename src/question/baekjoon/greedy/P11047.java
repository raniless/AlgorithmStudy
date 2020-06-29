package question.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
10 4200
1
5
10
50
100
500
1000
5000
10000
50000

[output]
6

[input]
10 4790
1
5
10
50
100
500
1000
5000
10000
50000

[output]
12

 */
public class P11047 {
    private static int N, K;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            A = new int[N+1];

            for(int i=1; i<=N; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }

            int result = 0;
            int remain = K;

            for(int i=N; i>=1; i--) {
                int value = A[i];
                if(value > K) {
                    continue;
                }

                int count = remain / value;
                remain = remain % value;

                result += count;

                if(remain == 0) {
                    break;
                }
            }

            bw.write(String.valueOf(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}