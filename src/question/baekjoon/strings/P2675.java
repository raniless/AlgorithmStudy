package question.baekjoon.strings;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
2
3 ABC
5 /HTP

[output]
AAABBBCCC
/////HHHHHTTTTTPPPPP

 */
public class P2675 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int T = Integer.parseInt(br.readLine());
            for(int t=1; t<=T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                String S = st.nextToken();

                for(int i=0; i<S.length(); i++) {
                    for(int k=0; k<R; k++) {
                        bw.write(S.charAt(i));
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
