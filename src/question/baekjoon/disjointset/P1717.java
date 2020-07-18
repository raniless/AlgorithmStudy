package question.baekjoon.disjointset;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

[output]
NO
NO
YES

 */
public class P1717 {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int mode = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if(mode == 0) {
                    union(n1, n2);
                }
                else if(mode == 1) {
                    boolean result = isSameGroup(n1, n2);
                    bw.write((result == true ? "YES" : "NO") + "\n");
                }
            }

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

    private static boolean isSameGroup(int n1, int n2) {
        int rootn1 = find(n1);
        int rootn2 = find(n2);

        if(rootn1 == rootn2) {
            return true;
        }

        return false;
    }
}