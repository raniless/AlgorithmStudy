package exercise.mst;

import java.io.*;
import java.util.*;

/*
[input]
6  8
1  2  7
1  3  3
2  4  10
3  4  1
3  5  6
3  6  10
4  5  13
5  6  4

[output]
21
 */

public class Prim {
    private static int N, E;
    private static int[] parent;
    private static boolean[] visited;
    private static List<Edge>[] edgeList;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new boolean[N+1];
            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            edgeList = new ArrayList[N+1];
            for(int i=1; i<=N; i++) {
                edgeList[i] = new ArrayList<>();
            }

            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edgeList[s].add(new Edge(s, e, w));
                edgeList[e].add(new Edge(e, s, w));
            }

            int start = 1;
            //시작노드를 하나 정한다
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
        //가중치가 낮은 순으로 정렬하기 위해 Heap 사용
        Queue<Edge> queue = new PriorityQueue<>();

        //시작 Node 기준으로 인접한 간선들을 
        queue.addAll(edgeList[start]);

        int sum = 0;
        int connectionCount = 0;
        while(!queue.isEmpty()) {
            if(connectionCount == N-1) {
                break;
            }

            Edge edge = queue.poll();
            System.out.println(edge);
            int s = edge.getS();
            int e = edge.getE();
            int w = edge.getW();

            if(visited[e]) {
                continue;
            }

            visited[e] = true;
            sum += w;
            connectionCount++;
            queue.addAll(edgeList[e]);
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

        @Override
        public String toString() {
            return s + " " + e + " " + w;
        }
    }
}