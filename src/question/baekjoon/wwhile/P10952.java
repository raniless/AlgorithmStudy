package question.baekjoon.wwhile;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
1 1
2 3
3 4
9 8
5 2
0 0

[output]
2
5
7
17
7

 */
public class P10952 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String readLine = "";
            StringTokenizer st = null;
            while(!"0 0".equals(readLine = br.readLine())) {
                st = new StringTokenizer(readLine);
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                bw.write(Integer.toString(A+B) + "\n");
            }

            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
