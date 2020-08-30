package question.baekjoon.topologicalsort;

import java.io.*;
import java.util.*;

/*
[input]
4 2
4 2
3 1

[output]
3 1 4 2

 */
public class P1766 {
    private static int N, M;
    private static int[] inDegree, result;
    private static List<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            inDegree = new int[N+1];
            result = new int[N+1];

            edge = new ArrayList[N+1];
            for(int i=1; i<=N; i++) {
                edge[i] = new ArrayList<>();
            }

            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edge[start].add(end);
                inDegree[end]++;
            }

            topologicalSort();

            for(int i=1; i<=N; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++) {
            if(inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        for(int i=1; i<=N; i++) {
            //N개 돌기 전에 큐가 비어 있으면 사이클이 있다는것.
            if(pq.isEmpty()) {
                System.out.println("사이클 발생");
                return;
            }

            int current = pq.poll();
            result[i] = current;

            for(int adj : edge[current]) {
                if(--inDegree[adj] == 0) {
                    pq.offer(adj);
                }
            }
        }
    }
}
