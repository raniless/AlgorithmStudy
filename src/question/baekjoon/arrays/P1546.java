package question.baekjoon.arrays;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
3
40 80 60

[output]
75.0

[input]
3
10 20 30

[output]
66.666667

 */
public class P1546 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            float N = Float.parseFloat(br.readLine());
            float maxScore = Float.MIN_VALUE;
            float totalScore = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                float value = Float.parseFloat(st.nextToken());
                maxScore = Math.max(maxScore, value);
                totalScore+=value;
            }

            float result = (totalScore/maxScore)*100/N;
            bw.write(Float.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}