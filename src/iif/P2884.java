package iif;

import java.io.*;
import java.util.StringTokenizer;

/*
[input]
10 10

[output]
9 25

[input]
0 30

[output]
23 45

[input]
23 40

[output]
22 55

 */
public class P2884 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int newH = 0;
            int newM = 0;
            boolean minusHour = false;
            if(M < 45) {
                newM = (M+60)-45;
                minusHour = true;
            }
            else {
                newM = M-45;
            }

            if(minusHour) {
                if(H == 0) {
                    newH = 23;
                }
                else {
                    newH = H-1;
                }

            }
            else {
                newH = H;
            }
            bw.write(Integer.toString(newH) + " " + Integer.toString(newM));
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
