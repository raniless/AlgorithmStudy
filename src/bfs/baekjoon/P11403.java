package bfs.baekjoon;

import java.io.*;
import java.util.*;

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
    private static List<Integer>[] graph;
    private static int[][] result;
    private static boolean[] checked;
    private static int N;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.valueOf(br.readLine());
            graph = new ArrayList[N+1];
            for(int i=1; i<=N; i++) {
                graph[i] = new ArrayList<>();
            }
            result = new int[N+1][N+1];
            checked = new boolean[N+1];

            StringTokenizer st = null;
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if(value == 1) {
                        graph[i].add(j);
                    }
                }
            }

            for(int i=1; i<=N; i++) {
                bfs(i, i);
                Arrays.fill(checked, false);
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println("");
            }

        }catch (IOException e) {
            throw e;
        }
    }

    private static void bfs(int start, int current) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int next : graph[node]) {
                if(checked[next] == false) {
                    result[start][next] = 1;
                    checked[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}