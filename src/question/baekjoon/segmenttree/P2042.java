package question.baekjoon.segmenttree;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[input]
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

[output]
17
12

 */
public class P2042 {
    private static int N, M, K;
    private static long[] data, tree;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            data = new long[N+1];
            tree = new long[N*4];

            for(int i=1; i<=N; i++) {
                data[i] = Long.parseLong(br.readLine());
            }

            init(1, N, 1);

//            printTree();

            for(int i=1; i<=M+K; i++) {
                st = new StringTokenizer(br.readLine());
                int mode = Integer.parseInt(st.nextToken());

                if(mode == 1) {
                    int index = Integer.parseInt(st.nextToken());
                    long value = Long.parseLong(st.nextToken());
                    update(index, value);
//                    printTree();
                }
                else if(mode == 2) {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    long sum = sum(1, N, 1, left, right);
                    bw.write(sum+"\n");
                }
            }
            bw.flush();

        }
        catch (Exception e) {
            throw e;
        }
    }

    private static long init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = data[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    private static void update(int index, long value) {
        long diff = value - data[index];
        data[index] = value;
        update(1, N, 1, index, diff);
    }

    private static void update(int start, int end, int node, int index, long diff) {
        if(index < start || end < index) {
            return;
        }

        tree[node] += diff;

        if(start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node*2, index, diff);
            update(mid+1, end, node*2+1, index, diff);
        }
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if(right < start || end < left) {
            return 0;
        }

        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    private static void printTree() {
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
