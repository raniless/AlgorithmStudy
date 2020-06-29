package question.baekjoon.arrays;

import java.io.*;

/*
[input]
150
266
427

[output]
3
1
0
2
0
0
0
2
0
0

 */
public class P2577 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int[] digits = new int[10];

            int A = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());
            int C = Integer.parseInt(br.readLine());

            String multiply = Integer.toString(A*B*C);
            for(int i=0; i<multiply.length(); i++) {
                int value = Character.digit(multiply.charAt(i), 10);
                digits[value]++;
            }

            for(int i=0; i<digits.length; i++) {
                bw.write(digits[i] + "\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
