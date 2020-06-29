package question.baekjoon.ffor;

import java.io.*;

/*
[input]
5

[output]
    *
   **
  ***
 ****
*****

 */
public class P2439 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());

            for(int i=1; i<=N; i++) {
                for(int j=N; j>=1; j--) {
                    if(j>i) {
                        bw.write(" ");
                    }
                    else {
                        bw.write("*");
                    }
                }
                bw.write("\n");
            }

            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
