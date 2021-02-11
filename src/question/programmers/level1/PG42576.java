package question.programmers.level1;

import java.util.HashMap;

// 완주하지 못한 선수
public class PG42576 {
    public static void main(String[] args) {
        PG42576 pg42576 = new PG42576();

        String[][] participants = new String[][]{{"leo", "kiki", "eden"}, {"marina", "josipa", "nikola", "vinko", "filipa"}, {"mislav", "stanko", "mislav", "ana"}};
        String[][] completions = new String[][]{{"eden", "kiki"}, {"josipa", "filipa", "marina", "nikola"}, {"stanko", "ana", "mislav"}};

        for(int i=0; i<participants.length; i++) {
            String answer = pg42576.solution(participants[i], completions[i]);
            System.out.println(answer);
        }
    }

    public String solution(String[] participant, String[] completion) {
        //HashMap에 완주자 name별 Count 집계
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : completion) {
           if(!map.containsKey(name)) {
               map.put(name, 1);
           }
           else {
               map.compute(name, (k, v) -> v+1);
           }
        }

        String answer = "";
        for(String name : participant) {
            //완주자 명단에 없는 사람
            if(!map.containsKey(name)) {
                answer = name;
                break;
            }

            //동명이인 중 완주를 못한 사람
            if(map.get(name) == 0) {
                answer = name;
                break;
            }

            map.compute(name, (k,v) -> v-1);
        }

        return answer;
    }
}
