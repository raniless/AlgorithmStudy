package question.baekjoon.mst;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
[input]
3 3
1 2 1
2 3 2
1 3 3

[output]
3

 */

public class P1197_Kruskal {
    private static int V, E;
    private static int[] parent;
    private static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parent = new int[V+1];
            for(int i = 1; i<= V; i++) {
                parent[i] = i;
            }
            edgeList = new ArrayList<>();

            for(int i = 1; i<= E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(s, e, w));
            }
            //가중치가 제일 작은 순으로 정렬
            Collections.sort(edgeList);

            int mst = kruskal();
            bw.write(mst+"\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static int kruskal() {
        int sum = 0;
        int connectionCount = 0;

        //가중치가 작은 간선 하나씩 연결
        for(Edge edge : edgeList) {
            //연결된 간선의 수가 N-1이면 MST 완선
            if(connectionCount == V -1) {
                break;
            }

            int s = edge.getS();
            int e = edge.getE();
            int w = edge.getW();

            if(find(s) != find(e)) {
                union(s, e);
                sum+=w;
                connectionCount++;
            }
        }

        return sum;
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return;
        }

        parent[parentB] = parentA;
    }

    private static int find(int n) {
        if(parent[n] == n) {
            return n;
        }

        return parent[n] = find(parent[n]);
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
