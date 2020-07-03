package question.baekjoon.strings;

import java.io.*;

/*
[input]
A

[output]
65

 */
public class P11654 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String value = br.readLine();
            bw.write(Integer.toString(value.charAt(0)));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}