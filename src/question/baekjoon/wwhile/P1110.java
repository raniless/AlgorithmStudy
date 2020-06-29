package question.baekjoon.wwhile;

import java.io.*;

/*
[input]
26

[output]
4

[input]
55

[output]
3

[input]
1

[output]
60

 */
public class P1110 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());
            String beforeValue = Integer.toString(N);
            String newValue = Integer.toString(N);
            int cycle = 0;

            do {
                beforeValue = newValue;

                cycle++;

                if(beforeValue.length() == 1) {
                    beforeValue = "0" + beforeValue;
                }

                int beforeLeftDigit  = Integer.parseInt(beforeValue.substring(0, 1));
                int beforeRightDigit = Integer.parseInt(beforeValue.substring(1, 2));

                String beforeEachDigitSum = Integer.toString(beforeLeftDigit + beforeRightDigit);

                newValue = beforeRightDigit + beforeEachDigitSum.substring(beforeEachDigitSum.length()-1, beforeEachDigitSum.length());
            }
            while(N != Integer.parseInt(newValue));

            bw.write(Integer.toString(cycle));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
