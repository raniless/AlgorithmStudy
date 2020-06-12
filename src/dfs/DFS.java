package dfs;

/*
[input]
5 5 1
1 2
1 3
2 3
2 4
3 5

6 5 1
1 3
1 2
3 4
3 5
2 6

[output]
1 2 3 5 4
1 2 6 3 4 5
 */

import java.io.*;
import java.util.*;

public class DFS {
    private static int V, E, S;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static List<Integer> dfsResult;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            initializeArgs();

            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            for(int i=1; i<=V; i++) {
                Collections.sort(graph[i]);
            }

            dfs(S);

            for(int bfsV : dfsResult) {
                bw.write(bfsV + " ");
            }
            bw.write("\n");

            bw.flush();
        }
        catch(IOException e){
            throw e;
        }
    }

    private static void initializeArgs() {
        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[V+1];
        dfsResult = new ArrayList<>();
    }

    private static void dfs(int start) {
        if(visited[start]) {
            return;
        }

        dfsResult.add(start);
        visited[start] = true;

        for(int next : graph[start]) {
            dfs(next);
        }
    }
}