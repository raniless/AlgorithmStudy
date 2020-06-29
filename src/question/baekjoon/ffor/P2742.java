package question.baekjoon.ffor;

import java.io.*;

/*
[input]
5

[output]
5
4
3
2
1

 */
public class P2742 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());

            for(int i=N; i>=1; i--) {
                bw.write(Integer.toString(i)+"\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
