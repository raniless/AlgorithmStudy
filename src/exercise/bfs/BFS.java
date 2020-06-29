package exercise.bfs;

import java.io.*;
import java.util.*;

/*
[Question]
첫 번째 줄에 그래프의 정점의 개수 V, 간선의 개수 E, 그리고 시작 정점의 번호 S가 공백으로 분리되어 주어진다. (1 ≤ S ≤ V ≤ 20,000, 1 ≤ E ≤ 100,000)
두 번째 줄부터 E개의 줄에 걸쳐 각 간선의 정보인 x, y가 공백으로 분리되어 주어진다. 이는 x와 y를 잇는 간선이 존재한다는 것을 의미한다. (1 ≤ x, y ≤ V, x ≠ y)
정점 S에서 시작한 너비 우선 탐색의 결과 중 오름차순으로 가장 빠른 것을 출력한다.

[input]
5 6 2
1 2
1 3
2 4
3 4
3 5
4 5

[output]
2 1 4 3 5
 */
public class BFS {
    private static int V, E, S;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static Queue<Integer> queue;
    private static List<Integer> bfsResult;

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

            bfs();

            for(int bfsV : bfsResult) {
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
        queue = new LinkedList<>();
        bfsResult = new ArrayList<>();
    }

    private static void bfs() {
        queue.add(S);
        visited[S] = true;

        while(!queue.isEmpty()){
            int currentV = queue.poll();
            bfsResult.add(currentV);

            for(int adjacentV : graph[currentV]) {
                if(!visited[adjacentV]) {
                    queue.add(adjacentV);
                    visited[adjacentV] = true;
                }
            }
        }
    }
}