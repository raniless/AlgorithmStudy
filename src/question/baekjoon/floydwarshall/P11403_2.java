package question.baekjoon.floydwarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[input]
3
0 1 0
0 0 1
1 0 0

[output]
1 1 1
1 1 1
1 1 1

[input]
7
0 0 0 1 0 0 0
0 0 0 0 0 0 1
0 0 0 0 0 0 0
0 0 0 0 1 1 0
1 0 0 0 0 0 0
0 0 0 0 0 0 1
0 0 1 0 0 0 0

[output]
1 0 1 1 1 1 1
0 0 1 0 0 0 1
0 0 0 0 0 0 0
1 0 1 1 1 1 1
1 0 1 1 1 1 1
0 0 1 0 0 0 1
0 0 1 0 0 0 0

 */
public class P11403_2 {
    private static int N;
    private static int[][] dist;
    private static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.parseInt(br.readLine());
            dist = new int[N+1][N+1];
            for(int start=1; start<=N; start++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int end=1; end<=N; end++) {
                    int value = Integer.parseInt(st.nextToken());
                    if(value == 0) {
                        value = INF;
                    }
                    dist[start][end] = value;
                }
            }

            floydWarshall();

            for(int start=1; start<=N; start++) {
                for(int end=1; end<=N; end++) {
                    bw.write((dist[start][end] == INF ? 0 : 1) + " ");
                }
                bw.write("\n");
            }
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