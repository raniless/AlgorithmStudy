package arithmetic.baekjoon;

import java.io.*;

/*
[input]
472
385

[output]
2360
3776
1416
181720
 */

public class P2588 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int A = Integer.parseInt(br.readLine());

            String strB = br.readLine();
            int B = Integer.parseInt(strB);
            int first = Character.digit(strB.charAt(2), 10);
            int second = Character.digit(strB.charAt(1), 10);
            int third = Character.digit(strB.charAt(0), 10);

            bw.write(Integer.toString(A*first) + "\n");
            bw.write(Integer.toString(A*second) + "\n");
            bw.write(Integer.toString(A*third) + "\n");
            bw.write(Integer.toString(A*B));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
