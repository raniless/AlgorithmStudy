package exercise.floydwarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
- 참고 URL : https://ssungkang.tistory.com/entry/Algorithm-%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%99%80%EC%83%ACFloyd-Warshall-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
[input]
5 9
1 2 3
3 2 4
1 3 8
1 5 -4
4 1 2
4 3 -5
2 5 7
2 4 1
5 4 6

[output]
0 1 -3 2 -4
3 0 -4 1 -1
7 4 0 5 3
2 -1 -5 0 -2
8 5 1 6 0

 */
public class FloydWarshall {
    private static int N, E;
    private static int[][] graph;   //인접
    private static int[][] dist;       //최단거리
    private static int[][] before;      //직전정점
    private static int INF = 100000000;

    /*
     Integer.MAX_VALUE를 못 쓰는 이유
      - mid : 2, start : 1, end : 1 인 경우
        2>1 과 1>2의 합이 Integer.MAX_VALUE를 넘어서 minus값으로 표현되면서 잘못된 계산 수행
      2>2 : 0
      2>1 : 2147483647
      1>2 : 3
     */
//    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new int[N+1][N+1];
            for(int[] arr :graph) {
                Arrays.fill(arr, INF);
            }

            dist = new int[N+1][N+1];
            for(int[] arr : dist) {
                Arrays.fill(arr, INF);
            }
            for(int i=1; i<=N; i++) {
                dist[i][i] = 0;
            }

            before = new int[N+1][N+1];
            for(int[] arr : before) {
                Arrays.fill(arr, INF);
            }

            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[start][end] = weight;
                dist[start][end] = weight;
                before[start][end] = start;
            }

//            printInitVariables();

            floydWarshall();

            System.out.println("--------------result-------------------");
            System.out.println("[dist]");
            printMatrix(dist);
            System.out.println("[before]");
            printMatrix(before);
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static void printInitVariables() {
        System.out.println("N :" + N);
        System.out.println("E : " + E);

        System.out.println("[graph]");
        printMatrix(graph);

        System.out.println("[dist]");
        printMatrix(dist);

        System.out.println("[pi]");
        printMatrix(before);
    }

    private static void printMatrix(int[][] matrix) {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                System.out.print((matrix[i][j] == INF ? "INF" : matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private static void floydWarshall() {
        //mid : 거쳐가는정점, start : 시작정점, end : 도착정점
        for(int mid=1; mid<=N; mid++) {
//            System.out.println("[mid : " + mid + "]");
            for(int start=1; start<=N; start++) {
                for(int end=1; end<=N; end++) {
//                    System.out.println("---------------------------------------");
//                    System.out.println(start+">"+end + " : " + dist[start][end]);
//                    System.out.println(start+">"+mid + " : " + dist[start][mid]);
//                    System.out.println(mid+">"+end + " : " + dist[mid][end]);
                     if(dist[start][end] > dist[start][mid] + dist[mid][end]) {
                        dist[start][end] = dist[start][mid] + dist[mid][end];
                        before[start][end] = before[mid][end];
                    }
                }
            }
        }
    }
}