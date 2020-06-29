package question.baekjoon.arrays;

import java.io.*;

/*
[input]
39
40
41
42
43
44
82
83
84
85

[output]
6

 */
public class P3052 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int divideNum = 42;
            boolean[] modCheck = new boolean[divideNum];

            for(int i=1; i<=10; i++) {
                int value = Integer.parseInt(br.readLine());
                modCheck[value%divideNum] = true;
            }

            int result = 0;
            for(int i=0; i<modCheck.length; i++) {
                if(modCheck[i]) {
                    result++;
                }
            }

            bw.write(Integer.toString(result));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
