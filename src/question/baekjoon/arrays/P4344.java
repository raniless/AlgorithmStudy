package question.baekjoon.arrays;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

[output]
40.000%
57.143%
33.333%
66.667%
55.556%

 */
public class P4344 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int C = Integer.parseInt(br.readLine());
            for(int i=1; i<=C; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int[] scores = new int[N+1];
                int total = 0;
                for(int j=1; j<=N; j++) {
                    int score = Integer.parseInt(st.nextToken());
                    scores[j] = score;
                    total+=score;
                }

                float avg = (float)total/(float)N;
                int count = 0;
                for(int idx=1; idx<scores.length; idx++) {
                    if(scores[idx] > avg) {
                        count++;
                    }
                }

                float answer = (float)count / (float)N;
                bw.write(String.format("%.3f", answer*100)+"%\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
