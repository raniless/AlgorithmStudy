package question.baekjoon.mst;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5

[output]
2
4

 */
public class P9372_2 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int T = Integer.parseInt(br.readLine());
            for(int t=1; t<=T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                for(int i=1; i<=M; i++) {
                    br.readLine();
                }

                bw.write(N-1 + "\n");
            }

            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
