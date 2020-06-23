package iif;

import java.io.*;

/*
[input]
2000

[output]
1

[input]
1999

[output]
0
 */
public class P2753 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int year = Integer.parseInt(br.readLine());

            int result = 0;
            if((year%4 == 0) && (!(year%100==0) || (year%400==0))) {
                result = 1;
            }

            bw.write(Integer.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
