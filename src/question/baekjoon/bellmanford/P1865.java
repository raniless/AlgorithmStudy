package question.baekjoon.bellmanford;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
[input]
2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8

[output]
NO
YES

 */

public class P1865 {
    private static int N, M, W;
    private static List<Edge> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int TC = Integer.parseInt(br.readLine());
            for(int t=1; t<=TC; t++) {
                initialize(br);

                String result = "NO";
                for(int i=1; i<=N; i++) {
                    if(bellmanFord(i)) {
                        result = "YES";
                        break;
                    }
                }

                bw.write(result + "\n");
            }

            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        dist = new int[N+1];

        graph = new ArrayList<>();
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //방향이 없음 -> 양방향
            graph.add(new Edge(src, dest, weight));
            graph.add(new Edge(dest, src, weight));
        }
        for(int i=1; i<=W; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //웜홀 -> 음수 가중치
            graph.add(new Edge(src, dest, (-1)*weight));
        }
    }

    private static boolean bellmanFord(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean updated = false;
        //N-1번만큼 반복
        for(int i=1; i<N; i++) {
            updated = false;
            for(Edge edge : graph) {
                int src = edge.getSrc();
                int dest = edge.getDest();
                int weight = edge.getWeight();

                if(dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                    updated = true;
                }
            }
            if(!updated) {
                break;
            }
        }

        boolean cycled = false;
        if(updated) {
            for (Edge edge : graph) {
                int src = edge.getSrc();
                int dest = edge.getDest();
                int weight = edge.getWeight();

                if (dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                    cycled = true;
                }
            }
        }

        return cycled;
    }

    private static class Edge {
        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSrc() {
            return src;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }
    }
}