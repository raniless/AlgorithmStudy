package question.baekjoon.ffor;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
5
1 1
12 34
5 500
40 60
1000 1000

[output]
2
46
505
100
2000

 */
public class P15552 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st = null;
            for(int i=1; i<=T; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                bw.write(Integer.toString(A+B) +"\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
