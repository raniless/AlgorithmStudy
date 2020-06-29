package question.baekjoon.ffor;

import java.io.*;

/*
[input]
2

[output]
2 * 1 = 2
2 * 2 = 4
2 * 3 = 6
2 * 4 = 8
2 * 5 = 10
2 * 6 = 12
2 * 7 = 14
2 * 8 = 16
2 * 9 = 18

 */
public class P2739 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.valueOf(br.readLine());

            for(int i=1; i<=9; i++) {
                bw.write(N + " * " + i + " = " + (N*i) + "\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
