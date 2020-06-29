package question.baekjoon.arithmetic;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
1 3

[output]
0.33333333333333333333333333333333

[input]
4 5

[output]
0.8
 */
public class P1008 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double result = A/B;

            bw.write(Double.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
