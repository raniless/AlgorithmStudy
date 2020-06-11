package sort.heap.baekjoon;

import java.io.*;

/*
[input]
5
5
4
3
2
1

[output]
1
2
3
4
5
 */
//class Main {
public class P2751 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.valueOf(br.readLine());
            int[] tree = new int[N+1];

            for(int i=1; i<=N; i++) {
                tree[i] = Integer.valueOf(br.readLine());
            }

            buildHeapTree(tree, N);
            sortTree(tree, N);

            for(int i=1; i<=N; i++) {
                bw.append(tree[i] + "\n");
            }

            bw.flush();
        }
        catch(IOException e) {
            throw e;
        }
    }

    private static void buildHeapTree(int[] tree, int N) {
        int start = N/2; //마지막 자식노드의 부모노드 ~ Root 노드까지
        for(int node=start; node>=1; node--) {
            sortMaxHeap(tree, node, N);
        }
    }

    private static void sortTree(int[] tree, int N) {
        for(int i=N; i>1; i--) {
            swap(tree, 1, i);
            sortMaxHeap(tree, 1, i-1);
        }
    }
    private static void sortMaxHeap(int[] tree, int node, int N){
        int leftChildNode = node*2;
        int rightChildNode = leftChildNode+1;

        int maxNode = node;
        //먼저 왼쪽 노드 비교하여 Max Node 도출
        if(leftChildNode <= N && (tree[leftChildNode] > tree[maxNode])) {
            maxNode = leftChildNode;
        }

        //오른쪽 노드와 비교하여 최종적으로 Max Node 도출
        if(rightChildNode <= N && (tree[rightChildNode] > tree[maxNode])) {
            maxNode = rightChildNode;
        }

        if(maxNode != node) {
            swap(tree, maxNode, node);
            sortMaxHeap(tree, maxNode, N);
        }
    }

    private static void swap(int[] tree, int node1, int node2) {
        int node1Value = tree[node1];
        tree[node1] = tree[node2];
        tree[node2] = node1Value;
    }
}