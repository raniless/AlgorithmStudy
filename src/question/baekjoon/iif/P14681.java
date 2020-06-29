package question.baekjoon.iif;

import java.io.*;

/*
[input]
12
5

[output]
1

[input]
9
-13

[output]
4

 */
public class P14681 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            int result = 0;
            if(x > 0 && y > 0) {
                result = 1;
            }
            else if(x < 0 && y > 0) {
                result = 2;
            }
            else if(x < 0 && y < 0) {
                result = 3;
            }
            else if(x > 0 && y < 0) {
                result = 4;
            }

            bw.write(Integer.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
