package exercise.disjointset;

import java.io.*;
import java.util.StringTokenizer;

/*
8 5
1 2
2 5
5 6
6 8
3 4

 */
public class DisjointSet {
    private static int N, E;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            for(int i=1; i<=N; i++) {
                System.out.print(parent[i] + " " );
            }
            System.out.println();

            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            for(int i=1; i<=N; i++) {
                System.out.print(parent[i] + " " );
            }
            System.out.println();

            System.out.println(find(8));

            for(int i=1; i<=N; i++) {
                System.out.print(parent[i] + " " );
            }
            System.out.println();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return;
        }

        parent[rootB] = rootA;
    }

    private static int find(int node) {
        if(parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}
