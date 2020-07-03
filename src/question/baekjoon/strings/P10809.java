package question.baekjoon.strings;

import java.io.*;

/*
[input]
baekjoon

[output]
1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

 */
public class P10809 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String S = br.readLine();

            for(int i='a'; i<='z'; i++) {
                String alphabet = Character.toString((char)i);
                bw.write(S.indexOf(alphabet) + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
