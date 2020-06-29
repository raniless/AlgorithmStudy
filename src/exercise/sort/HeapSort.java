package exercise.sort;

import java.io.*;


public class HeapSort {
    private static int n;
    private static int[] heapTree;
    private static int[] sortedTree;
    private static int heapSize;
    private static final int ROOT_NODE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        n = Integer.valueOf(br.readLine());
//        heapTree = new int[n+1];
//        makeheap();

        int[] values = new int[]{7, 6, 5, 8, 3, 5, 9, 1, 6};
        heapSize = values.length;
        heapTree = new int[heapSize+1];
        sortedTree = new int[heapSize+1];

        for(int i=1; i<=heapSize; i++) {
            heapTree[i] = values[i-1];
        }

        buildHeapTree();

        for(int i=1; i<=heapSize; i++) {
            System.out.println(heapTree[i]);
        }
    }

    private static void buildHeapTree() {
        int start = heapSize/2; //마지막 자식노드의 부모노드 ~ Root 노드까지
        for(int node=start; node>=1; node--) {
            System.out.println("node : " + node);
            sortMaxHeap(node);
        }
    }

    private static void sortMaxHeap(int node){
        int leftChildNode = node*2;
        int rightChildNode = leftChildNode+1;

        int maxNode = node;
        //먼저 왼쪽 노드 비교하여 Max Node 도출
        if(leftChildNode < heapSize && heapTree[leftChildNode] > heapTree[node]) {
            maxNode = leftChildNode;
        }
        
        //오른쪽 노드와 비교하여 최종적으로 Max Node 도출
        if(rightChildNode < heapSize && heapTree[rightChildNode] > heapTree[maxNode]) {
            maxNode = rightChildNode;
        }

        if(maxNode != node) {
            swap(maxNode, node);
            sortMaxHeap(maxNode);
        }
    }

    private static void swap(int x, int y) {
        int temp = heapTree[x];
        heapTree[x] = heapTree[y];
        heapTree[y] = temp;
    }
}