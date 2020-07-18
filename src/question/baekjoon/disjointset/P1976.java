package question.baekjoon.disjointset;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
3
3
0 1 0
1 0 1
0 1 0
1 2 3

[output]
YES

 */
public class P1976 {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            for(int i=1; i<=N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++) {
                    int connection = Integer.parseInt(st.nextToken());

                    if(connection == 1) {
                        union(i, j);
                    }
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = -1;
            String connected = "YES";
            for(int i=1; i<=M; i++) {
                int node = Integer.parseInt(st.nextToken());
                if(i == 1) {
                    root = find(node);
                    continue;
                }

                if(root != find(node)) {
                    connected = "NO";
                }
            }

            bw.write(connected);
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void union(int n1, int n2) {
        int rootn1 = find(n1);
        int rootn2 = find(n2);

        if(rootn1 == rootn2) {
            return;
        }

        parent[rootn2] = rootn1;
    }

    private static int find(int node) {
        if(parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}
