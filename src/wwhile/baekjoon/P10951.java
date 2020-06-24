package wwhile.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
1 1
2 3
3 4
9 8
5 2

[output]
2
5
7
17
7

 */
public class P10951 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String readLine = "";
            StringTokenizer st = null;

            while((readLine = br.readLine()) != null) {
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
