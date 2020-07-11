package question.baekjoon.floydwarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[input]
7
6
1 2
2 3
1 5
5 2
5 6
4 7

[output]
4

 */
public class P2606 {
    private static int N, E;
    private static int[][] dist;
    private static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.parseInt(br.readLine());
            E = Integer.parseInt(br.readLine());

            dist = new int[N+1][N+1];
            for(int[] arr : dist) {
                Arrays.fill(arr, INF);
            }
            for(int i=1; i<=N; i++) {
                dist[i][i] = 0;
            }

            for(int i=1; i<=E; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                dist[start][end] = 1;
                dist[end][start] = 1;
            }

            floydWarshall();

            int result = 0;
            for(int i=2; i<=N; i++) {
                if(dist[1][i] != INF) {
                    result++;
                }
            }

            bw.write(result+"\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void floydWarshall() {
        for(int mid=1; mid<=N; mid++) {
            for(int start=1; start<=N; start++) {
                for(int end=1; end<=N; end++) {
                    if(dist[start][end] > dist[start][mid] + dist[mid][end]) {
                        dist[start][end] = dist[start][mid] + dist[mid][end];
                    }
                }
            }
        }
    }
}
