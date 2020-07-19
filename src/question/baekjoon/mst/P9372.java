package question.baekjoon.mst;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5

[output]
2
4

 */
public class P9372 {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int T = Integer.parseInt(br.readLine());
            for(int t=1; t<=T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                parent = new int[N+1];
                for(int i=1; i<=N; i++) {
                    parent[i] = i;
                }

                int result = 0;
                for(int i=1; i<=M; i++) {
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if(find(a) != find(b)) {
                        union(a, b);
                        result++;
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
}
