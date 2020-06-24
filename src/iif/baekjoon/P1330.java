package iif.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
1 2

[output]
<

[input]
10 2

[output]
>

[input]
5 5

[output]
==

 */
public class P1330 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int compare = Integer.compare(A, B);

            String result = "";
            if(compare == -1) {
                result = "<";
            }
            else if(compare == 0) {
                result = "==";
            }
            else if(compare == 1) {
                result = ">";
            }

            bw.write(result);
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
