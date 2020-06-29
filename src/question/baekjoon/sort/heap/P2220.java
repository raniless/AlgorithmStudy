package question.baekjoon.sort.heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[input]
6

[output]
6 5 3 2 4 1
 */
//클래스명을 Main으로 해야함
//class Main
public class P2220 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int n = Integer.valueOf(br.readLine());
            int[] tree = new int[n + 1];

            buildMaxSwapHeapTree(tree, n);

            for (int node = 1; node <= n; node++) {
                bw.write(tree[node] + "\n");
            }

            bw.flush();
        }
        catch(IOException e) {
            throw e;
        }
    }

    private static void buildMaxSwapHeapTree(int[] tree, int lastNode) {
        for(int node=1; node<=lastNode; node++) {
            tree[node] = node;

            if(node > 1) {
                swap(tree, node, node - 1);
                sortMaxHeapTree(tree, node - 1);
            }
        }
    }

    private static void swap(int[] tree, int node1, int node2) {
        int node1Value = tree[node1];
        tree[node1] = tree[node2];
        tree[node2] = node1Value;
    }

    private static void sortMaxHeapTree(int[] tree, int node) {
        if(node == 1) {
            return;
        }

        int parent = node / 2;
        if(tree[node] > tree[parent]) {
            swap(tree, node, parent);
            sortMaxHeapTree(tree, parent);
        }
    }
}