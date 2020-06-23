package arithmetic;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
5 8 4

[output]
1
1
0
0

 */
public class P10430 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString((A+B)%C) + "\n");
            bw.write(Integer.toString(((A%C) + (B%C))%C) + "\n");
            bw.write(Integer.toString((A*B)%C) + "\n");
            bw.write(Integer.toString(((A%C)*(B%C))%C) + "\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
