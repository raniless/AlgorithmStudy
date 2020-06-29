package question.baekjoon.arrays;

import java.io.*;

/*
[input]
3
29
38
12
57
74
40
85
61

[output]
85
8

 */
public class P2562 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int maxValue = Integer.MIN_VALUE;
            int order = 0;

            for(int i=1; i<=9; i++) {
                int value = Integer.parseInt(br.readLine());
                if(value > maxValue) {
                    maxValue = value;
                    order = i;
                }
            }

            bw.write(maxValue + "\n");
            bw.write(Integer.toString(order));
        }
        catch (Exception e) {
            throw e;
        }
    }
}
