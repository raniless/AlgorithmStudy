package question.baekjoon.dijkstra;

import java.io.*;
import java.util.*;

/*
[input]
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

[output]
0
2
3
7
INF

 */
public class P1753 {
    private static int V, E, K;
    private static List<NodeAndDist>[] graph;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(br.readLine());

            graph = new ArrayList[V+1];
            for(int i=1; i<=V; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[V+1];
            dist = new int[V+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to   = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[from].add(new NodeAndDist(to, weight));
            }

            dijkstra(K);

            for(int i=1; i<=V; i++) {
                String value = Integer.MAX_VALUE == dist[i] ? "INF" : Integer.toString(dist[i]);
                bw.write(value + "\n");
            }
            bw.flush();
        }
        catch(Exception e) {
            throw e;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<NodeAndDist> pq = new PriorityQueue<>();
        pq.offer(new NodeAndDist(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            NodeAndDist nodeAndDist = pq.poll();

            int currentNode = nodeAndDist.node;
            int currentDist = nodeAndDist.dist;

            if(visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;

            if(currentDist > dist[currentNode]) {
                continue;
            }

            for(NodeAndDist adjNodeAndDist : graph[currentNode]) {
                int adjNode = adjNodeAndDist.node;
                int adjDist = adjNodeAndDist.dist;
                if(visited[adjNode] == false) {
                    dist[adjNode] = Math.min(dist[adjNode], dist[currentNode] + adjDist);
                    pq.offer(new NodeAndDist(adjNode, dist[adjNode]));
                }
            }
        }
    }

    static class NodeAndDist implements Comparable<NodeAndDist> {
        int node;
        int dist;

        public NodeAndDist(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(NodeAndDist o) {
            return dist - o.dist;
        }
    }
}

