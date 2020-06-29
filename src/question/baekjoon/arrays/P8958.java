package question.baekjoon.arrays;

import java.io.*;

/*
[input]
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX

[output]
10
9
7
55
30

 */
public class P8958 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=1; i<=N; i++) {
                int score = 0;
                int total = 0;

                String quiz = br.readLine();
                for(int j=0; j<quiz.length(); j++) {
                    char ch = quiz.charAt(j);
                    if('O' == ch) {
                        score++;
                    }
                    else {
                        score = 0;
                    }
                    total += score;
                }
                bw.write(total+"\n");
            }
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
