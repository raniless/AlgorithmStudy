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
240
48

[input]
5 2 2
1
2
3
4
5
1 3 0
2 2 5
1 3 6
2 2 5

[output]
0
240

 */
public class P11505 {
    private static int N, M, K;
    private static long[] data, tree;
    private static int divideNum = 1000000007;

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
                data[i] = Integer.parseInt(br.readLine());
            }

            init(1, N, 1);

//            printTree();

            for(int i=1; i<=M+K; i++) {
                st = new StringTokenizer(br.readLine());
                int mode = Integer.parseInt(st.nextToken());

                if(mode == 1) {
                    int index = Integer.parseInt(st.nextToken());
                    long value = Integer.parseInt(st.nextToken());
                    update(index, value);
//                    printTree();
                }
                else if(mode == 2) {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    long result = multiply(1, N, 1, left, right);
                    bw.write(result+"\n");
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
        return tree[node] = init(start, mid, node*2) * init(mid+1, end, node*2+1) % divideNum;
    }

    private static void update(int index, long value) {
        data[index] = value;
        update(1, N, 1, index, value);
    }

    private static long update(int start, int end, int node, int index, long value) {
        if(index < start || end < index) {
            return tree[node];
        }

        if(start == end && start == index) {
            return tree[node] = value;
        }

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node*2, index, value) * update(mid+1, end, node*2+1, index, value) % divideNum;
    }

    private static long multiply(int start, int end, int node, int left, int right) {
        if(right < start || end < left) {
            return 1;
        }

        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return multiply(start, mid, node*2, left, right) * multiply(mid+1, end, node*2+1, left, right) % divideNum;
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
