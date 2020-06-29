package question.baekjoon.greedy;

import java.io.*;
import java.util.*;

/*
[input]
5
3 1 4 3 2

[output]
32

 */
public class P11399 {
    private static int N;
    private static List<Integer> P;
    private static List<Integer> PSUM;
    private static int result;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            N = Integer.parseInt(br.readLine());
            P = new ArrayList<>();
            PSUM = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                P.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(P);
            int sum = 0;
            for(int value : P) {
                sum += value;
                PSUM.add(sum);
            }

            for(int value : PSUM) {
                result += value;
            }

            bw.write(result + "\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}