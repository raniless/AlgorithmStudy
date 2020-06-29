package question.baekjoon.bfs;

import java.io.*;
import java.util.*;

/*
[input]
4 5 1
1 2
1 3
1 4
2 4
3 4

[output]
1 2 4 3
1 2 3 4

[input]
5 5 3
5 4
5 2
1 2
3 4
3 1

[output]
3 1 2 5 4
3 1 4 2 5

[input]
1000 1 1000
999 1000

[output]
1000 999
1000 999

 */
//class Main {
public class P1260 {
    private static int N, M, V;
    private static List<Integer>[] graph;
    private static List<Integer> dfs;
    private static List<Integer> bfs;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            initializeArgs();

            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            for(int i=1; i<=N; i++) {
                Collections.sort(graph[i]);
            }

            dfs(V);
            Arrays.fill(visited, false);
            bfs(V);

            for(int start : dfs) {
                bw.write(start + " ");
            }
            bw.write("\n");

            for(int start : bfs) {
                bw.write(start + " ");
            }
            bw.flush();
        }
        catch (IOException e) {
            throw e;
        }
    }

    private static void initializeArgs() {
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        dfs = new ArrayList<>();
        bfs = new ArrayList<>();
        visited = new boolean[N+1];
    }

    private static void dfs(int start) {
        if(visited[start]) {
            return;
        }

        visited[start] = true;
        dfs.add(start);

        for(int next : graph[start]) {
            dfs(next);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            bfs.add(current);

            for(int next : graph[current]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}