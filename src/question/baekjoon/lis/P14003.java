package question.baekjoon.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
[input]
6
10 20 10 30 20 50

[output]
4
10 20 30 50

[input]
4
1 3 4 2

[output]
1 3 4

[input]
6
4 9 11 5 7 8

[output]
4
4 5 7 8

[input]
8
1 6 2 5 7 3 5 6

[output]
5
1 2 3 5 6

 */
public class P14003 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] lisIdx = new int[N+1];
            List<Integer> lis = new ArrayList<>();
            lis.add(Integer.MIN_VALUE);

            for(int i=1; i<=N; i++) {
                int val = A[i];
                if(val > lis.get(lis.size()-1)) {
                    lis.add(val);
                    lisIdx[i] = lis.size()-1;
                }
                else {
                    int idx = search(lis, 0, lis.size()-1, val);
                    lis.set(idx, val);
                    lisIdx[i] = idx;
                }
            }
            lis.remove(0);

            Stack<Integer> stack = new Stack<>();
            int idx = lis.size();
            for(int i=N; i>=1; i--) {
                if(lisIdx[i] == idx) {
                    stack.push(A[i]);
                    idx--;
                }
            }

            bw.write(stack.size() + "\n");
            while(!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        catch (Exception e) {
            throw e;
        }
    }

    private static int search(List<Integer> lis, int start, int end, int val) {
        if(start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        return lis.get(mid) >= val ? search(lis, start, mid, val) : search(lis, mid+1, end, val);
    }
}