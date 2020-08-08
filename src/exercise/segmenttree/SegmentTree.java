package exercise.segmenttree;

import java.io.*;
import java.util.StringTokenizer;

/*
12 8
1 9 3 8 4 5 5 9 10 3 4 5
0 1 5
0 2 3
0 3 9
1 1 5
1 4 2
0 1 5
0 2 3
0 3 9
 */
public class SegmentTree {
    private static int N, M;
    private static int[] data, tree;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            data = new int[N+1];
            tree = new int[N*4];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            init(1, N, 1);

            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int mode = Integer.parseInt(st.nextToken());

                if(mode == 0) {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    int sum = sum(1, N, 1, left, right);
                    bw.write(sum+"\n");
                }
                else if(mode == 1) {
                    int node = Integer.parseInt(st.nextToken());
                    int diff = Integer.parseInt(st.nextToken());
                    update(1, N, 1, node, diff);
                }
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static int init(int start, int end, int treeNode) {
        if(start == end) {
            return tree[treeNode] = data[start];
        }

        int mid = (start + end) / 2;
        return init(1, mid, treeNode*2) + init(mid+1, end, (treeNode*2)+1);
    }

    private static int sum(int start, int end, int treeNode, int left, int right) {
        //left-right 범위가 start-end 범위 밖에 있는 경우
        if(right < start || end < left) {
            return 0;
        }
        //start-end 범위가 left-right 범위 안에 있는 경우
        if(left <= start && end <= right) {
            return tree[treeNode];
        }
        //그렇지 않으면 두 부분으로 나누어 합 구하기
        //left-right 범위가 start-end 범위 안에 있거나 일부가 겹치는 경우
        int mid = (start + end) / 2;
        return sum(start, mid, treeNode*2, left, right) + sum(mid+1, end, treeNode*2+1, left, right);
    }

    private static void update(int start, int end, int treeNode, int node, int diff) {
        if(node < start || end < node) {
            return;
        }

        tree[treeNode] += diff;
        int mid = start + end;
        update(start, mid, treeNode*2, node, diff);
        update(mid+1, end, treeNode*2, node, diff);
    }
}