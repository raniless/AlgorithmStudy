package question.programmers.level1;

// 서울에서 김서방 찾기
public class PG12919 {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        PG12919 pg12919 = new PG12919();
        String answer = pg12919.solution(seoul);
        System.out.println(answer);
    }

    public String solution(String[] seoul) {
        int idx = 0;
        for(int i=0; i<seoul.length; i++) {
            if("Kim".equals(seoul[i])) {
                idx = i;
                break;
            }
        }

        return "김서방은 " + idx + "에 있다";
    }
}
