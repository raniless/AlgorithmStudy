package arithmetic.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
3 2

[output]
1
 */
public class P1001 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = A-B;

            bw.write(Integer.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
