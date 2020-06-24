package ffor.baekjoon;

import java.io.*;

/*
[input]
3

[output]
6
 */
public class P8393 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int i=1; i<=n; i++) {
                sum+=i;
            }

            bw.write(Integer.toString(sum));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
