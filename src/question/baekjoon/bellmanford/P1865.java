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
    private static int TC, N, M, W;
    private static List<Edge> graph = new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            TC = Integer.parseInt(br.readLine());
            for(int tc=1; tc<=TC; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                W = Integer.parseInt(st.nextToken());

                dist = new int[N+1];
                Arrays.fill(dist, Integer.MAX_VALUE);

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

                bellmanFord(1);
                boolean cycled = existCycle();

                if (cycled) {
                    bw.write("YES");
                } else {
                    bw.write("NO");
                }
                bw.write("\n");
            }

            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void bellmanFord(int start) {
        dist[start] = 0;

        //N-1번만큼 반복
        for(int i=1; i<N; i++) {
            for(Edge edge : graph) {
                int src = edge.getSrc();
                int dest = edge.getDest();
                int weight = edge.getWeight();

                if(dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }
    }

    private static boolean existCycle() {
        for(Edge edge : graph) {
            int src = edge.getSrc();
            int dest = edge.getDest();
            int weight = edge.getWeight();

            if(dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                return true;
            }
        }

        return false;
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