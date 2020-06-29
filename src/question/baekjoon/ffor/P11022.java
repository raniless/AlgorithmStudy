package question.baekjoon.ffor;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
5
1 1
2 3
3 4
9 8
5 2

[output]
Case #1: 1 + 1 = 2
Case #2: 2 + 3 = 5
Case #3: 3 + 4 = 7
Case #4: 9 + 8 = 17
Case #5: 5 + 2 = 7

 */
public class P11022 {
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

                bw.write("Case #"+i+": " + A + " + " + B + " = " + (A+B) + "\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
