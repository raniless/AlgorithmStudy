package question.baekjoon.segmenttree;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[input]
10 4
75
30
100
38
50
51
52
20
81
5
1 10
3 5
6 9
8 10

[output]
5 100
38 100
20 81
5 81

 */
public class P2357 {
    private static int N, M;

    private static int[] data, minTree, maxTree;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            data = new int[N+1];
            minTree = new int[N*4];
            maxTree = new int[N*4];

            for(int i=1; i<=N; i++) {
                data[i] = Integer.parseInt(br.readLine());
            }

            initMinTree(1, N, 1);
            initMaxTree(1, N, 1);

//            System.out.println("[mintree]");
//            printTree(minTree);
//            System.out.println("[maxtree]");
//            printTree(maxTree);

            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                int min = min(1, N, 1, left, right);
                int max = max(1, N, 1, left, right);

                bw.write(min + " " + max + "\n");
            }

            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static int initMinTree(int start, int end, int node) {
        if(start == end) {
            return minTree[node] = data[start];
        }

        int mid = (start + end) / 2;
        return minTree[node] = Math.min(initMinTree(start, mid, node*2), initMinTree(mid+1, end, node*2+1));
    }

    private static int initMaxTree(int start, int end, int node) {
        if(start == end) {
            return maxTree[node] = data[start];
        }

        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(initMaxTree(start, mid, node*2), initMaxTree(mid+1, end, node*2+1));
    }

    private static int min(int start, int end, int node, int left, int right) {
        if(right < start || end < left) {
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(min(start, mid, node*2, left, right), min(mid+1, end, node*2+1, left, right));
    }

    private static int max(int start, int end, int node, int left, int right) {
        if(right < start || end < left) {
            return Integer.MIN_VALUE;
        }

        if(left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;
        return Math.max(max(start, mid, node*2, left, right), max(mid+1, end, node*2+1, left, right));
    }

    private static void printTree(int[] tree) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        float depth = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(depth != Math.getExponent(node)) {
                System.out.println();
                depth = Math.getExponent(node);
            }

            System.out.print(tree[node] + " ");

            int left = node*2;
            int right = node*2+1;
            if(left < tree.length) {
                queue.offer(left);
            }
            if(right < tree.length) {
                queue.offer(right);
            }
        }
        System.out.println();
    }
}
