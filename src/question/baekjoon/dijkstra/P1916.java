package question.baekjoon.dijkstra;

import java.io.*;
import java.util.*;

/*
[input]
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

[output]
4

 */
public class P1916 {
    private static int N, M;
    private static List<NodeAndWeight>[] graph;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            graph = new ArrayList[N+1];
            for(int i=1; i<=N; i++) {
                graph[i]= new ArrayList<>();
            }
            visited = new boolean[N+1];
            dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            StringTokenizer st = null;
            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[from].add(new NodeAndWeight(to, weight));
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dijkstra(start);

            bw.write(Integer.toString(dist[end]));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<NodeAndWeight> pq = new PriorityQueue<>();
        pq.offer(new NodeAndWeight(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            NodeAndWeight target = pq.poll();
            int targetNode = target.node;
            int targetDist = target.weight;

            if(visited[targetNode]) {
                continue;
            }
            visited[targetNode] = true;

            if(targetDist > dist[targetNode]) {
                continue;
            }

            for(NodeAndWeight adj : graph[targetNode]) {
                int adjNode = adj.node;
                int adjWeight = adj.weight;

                dist[adjNode] = Math.min(dist[adjNode], dist[targetNode] + adjWeight);
                pq.offer(new NodeAndWeight(adjNode, dist[adjNode]));
            }
        }
    }

    static class NodeAndWeight implements Comparable<NodeAndWeight> {
        int node;
        int weight;

        public NodeAndWeight(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(NodeAndWeight o) {
            return weight - o.weight;
        }
    }
}