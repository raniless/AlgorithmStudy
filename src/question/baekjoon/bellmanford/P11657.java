package question.baekjoon.bellmanford;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[input]
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

[output]
4
3

[input]
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2

[output]
-1

[input]
3 2
1 2 4
1 2 3

[output]
3
-1

 */

public class P11657 {
    private static int N, M;
    private static Edge[] graph;
    //음의 사이클에서 int 범위를 초과하는 Case가 존재하기 때문에 long으로 선언 필수
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dist = new long[N+1];
            Arrays.fill(dist, Long.MAX_VALUE);

            graph = new Edge[M];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[i] = new Edge(src, dest, weight);
            }

            bellmanFord(1);
            boolean cycled = existCycle();

            if(cycled) {
                bw.write(-1+"\n");
            }
            else {
                for(int i=2; i<=N; i++) {
                    long result = (dist[i] == Long.MAX_VALUE) ? -1 : dist[i];
                    bw.write(result+"\n");
                }
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

                if(dist[src] != Long.MAX_VALUE && dist[dest] > dist[src] + weight) {
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

            if(dist[src] != Long.MAX_VALUE && dist[dest] > dist[src] + weight) {
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