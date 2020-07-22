package question.baekjoon.mst;

import java.io.*;
import java.util.*;

/*
[input]
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

[output]
23

 */

public class P1922_Prim {
    private static int N, M;
    private static int[] parent;
    private static boolean[] visited;
    private static List<Edge>[] edgeList;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            edgeList = new ArrayList[N+1];
            for(int i=1; i<=N; i++) {
                edgeList[i] = new ArrayList<>();
            }

            for(int i=1; i<=M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edgeList[s].add(new Edge(s, e, w));
                edgeList[e].add(new Edge(e, s, w));
            }

            //시작노드를 하나 정한다
            int start = 1;
            int mst = prim(start);
            bw.write(mst+"\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static int prim(int start) {
        visited[start] = true;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.addAll(edgeList[start]);

        int edgeCount = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            if(edgeCount == N-1) {
                break;
            }

            Edge edge = pq.poll();
            int e = edge.e;
            int w = edge.w;

            if(visited[e]) {
                continue;
            }

            visited[e] = true;
            edgeCount++;
            sum+=w;
            pq.addAll(edgeList[e]);
        }

        return sum;
    }

    static class Edge implements Comparable<Edge> {
        private int s;
        private int e;
        private int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }

        public int getW() {
            return w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.getW();
        }
    }
}
