package question.programmers.level1;

// 문자열 내 p와 y의 개수
public class PG12916 {
    public static void main(String[] args) {
        String[] tests = {"pPoooyY", "Pyy"};

        PG12916 pg12916 = new PG12916();
        for(String s : tests) {
            boolean answer = pg12916.solution(s);
            System.out.println(answer);
        }
    }

    public boolean solution(String s) {
        if(s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();

        if(s.indexOf("s") == 1 && s.indexOf("p") == -1) {
            return true;
        }

        int pCnt = s.replaceAll("[^p]", "").length();
        int yCnt = s.replaceAll("[^y]", "").length();

        return pCnt == yCnt;
    }
}
