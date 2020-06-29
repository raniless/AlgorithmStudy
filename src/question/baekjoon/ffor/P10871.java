package question.baekjoon.ffor;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
10 5
1 10 4 9 2 3 8 5 7 6

[output]
1 4 2 3

 */
public class P10871 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                int value = Integer.parseInt(st.nextToken());

                if(value < X) {
                    bw.write(Integer.toString(value) + " ");
                }
            }

            bw.flush();

        }
        catch (Exception e) {
            throw e;
        }
    }
}
