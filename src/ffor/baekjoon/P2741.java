package ffor.baekjoon;

import java.io.*;

/*
[input]
5

[output]
1
2
3
4
5

 */
public class P2741 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());

            for(int i=1; i<=N; i++) {
                bw.write(Integer.toString(i)+"\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
