package question.baekjoon.floydwarshall;

import java.io.*;
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
public class P11403 {
    private static int N;
    private static int[][] dist;
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
                    dist[start][end] = value;
                }
            }

            floydWarshall();

            for(int start=1; start<=N; start++) {
                for(int end=1; end<=N; end++) {
                    bw.write(dist[start][end] + " ");
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
                    if(dist[start][mid] == 1 && dist[mid][end] == 1) {
                        dist[start][end] = 1;
                    }
                }
            }
        }
    }
}