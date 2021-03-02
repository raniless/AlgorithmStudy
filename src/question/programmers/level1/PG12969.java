package question.programmers.level1;

import java.util.Scanner;

// 직사각형 별찍기
public class PG12969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=0; i<b; i++) {
            String s = "";
            for(int j=0; j<a; j++) {
                s += "*";
            }
            System.out.println(s);
        }
    }
}
