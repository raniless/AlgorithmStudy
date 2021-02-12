package question.programmers.level1;

import java.util.Arrays;

// 체육복
public class PG42862 {
    public static void main(String[] args) {
        PG42862 pg42862 = new PG42862();

        int answer = 0;

//        answer = pg42862.solution(5, new int[]{2, 4}, new int[]{1,3,5});
        answer = pg42862.solution2(5, new int[]{2, 4}, new int[]{1,3,5});
        System.out.println(answer);
//        answer = pg42862.solution(5, new int[]{2, 4}, new int[]{3});
        answer = pg42862.solution2(5, new int[]{2, 4}, new int[]{3});
        System.out.println(answer);
//        answer = pg42862.solution(3, new int[]{3}, new int[]{1});
        answer = pg42862.solution2(3, new int[]{3}, new int[]{1});
        System.out.println(answer);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] losted = new boolean[n+1];
        Arrays.fill(losted, false);

        for(int student : lost) {
            losted[student] = true;
        }

        Arrays.sort(reserve);
        for(int i=0; i<reserve.length; i++) {
            int student = reserve[i];
            if(losted[student]) {
                losted[student] = false;
                reserve[i] = -1;
            }
        }

        for(int student : reserve) {
            if(student == -1) {
                continue;
            }

            if(student > 1 && losted[student-1]){
                losted[student-1] = false;
            }
            else if(student < n && losted[student+1]) {
                losted[student+1] = false;
            }
        }

        int lostCnt = 0;
        for(int i=1; i<=n; i++) {
            if(losted[i]) {
                lostCnt++;
            }
        }

        return n - lostCnt;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] sportsClothes = new int[n];

        for(int student : lost) {
            sportsClothes[student-1]--;
        }

        for(int student : reserve) {
            sportsClothes[student-1]++;
        }

        int answer = n;
        for(int student=0; student<sportsClothes.length; student++) {
            if(sportsClothes[student] == -1) {
                if(student > 0 && sportsClothes[student-1] == 1) {
                    sportsClothes[student]++;
                    sportsClothes[student-1]--;
                }
                else if(student < sportsClothes.length-1 && sportsClothes[student+1] == 1) {
                    sportsClothes[student]++;
                    sportsClothes[student+1]--;
                }
                else {
                    answer--;
                }
            }
        }

        return answer;
    }
}