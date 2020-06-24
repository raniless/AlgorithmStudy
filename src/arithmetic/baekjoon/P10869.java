package arithmetic.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
7 3

[output]
10
4
21
2
1

 */
public class P10869 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString(A+B) + "\n");
            bw.write(Integer.toString(A-B) + "\n");
            bw.write(Integer.toString(A*B) + "\n");
            bw.write(Integer.toString(A/B) + "\n");
            bw.write(Integer.toString(A%B));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
