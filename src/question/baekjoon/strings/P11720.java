package question.baekjoon.strings;

import java.io.*;

/*
[input]
11
10987654321

[output]
46

 */
public class P11720 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());
            String data = br.readLine();
            int sum = 0;
            for(int i=0; i<N; i++) {
                int value = Character.digit(data.charAt(i), 10);
                sum += value;
            }

            bw.write(Integer.toString(sum));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
