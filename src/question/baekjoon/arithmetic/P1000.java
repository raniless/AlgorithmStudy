package question.baekjoon.arithmetic;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
1 2

[output]
3
 */
public class P1000 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = A+B;

            bw.write(Integer.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
