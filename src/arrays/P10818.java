package arrays;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
5
20 10 35 30 7

[output]
7 35

 */
public class P10818 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                int value = Integer.parseInt(st.nextToken());
                min = Math.min(min, value);
                max = Math.max(max, value);
            }

            bw.write(Integer.toString(min) + " " + Integer.toString(max));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
