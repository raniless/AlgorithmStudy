package question.programmers.level2;

// 124 나라의 숫자
public class PG12899 {
    public static void main(String[] args) {
        int[] tests = {1,2,3,4,5,6,7,8,9,10};

        PG12899 pg12899 = new PG12899();
        for(int n : tests) {
            String answer = pg12899.solution(n);
            System.out.println(answer);
        }
    }

    /*
    //Self
    public String solution(int n) {
        int digit = n;

        StringBuffer sb = new StringBuffer();
        while(digit > 0) {
            int mod = digit % 3;
            if(mod == 0) {
                mod = 3;
                digit -=3;
            }

            sb.insert(0, getConvert124NaraDigit(mod));

            digit/=3;
        }

        return sb.toString();
    }

    private String getConvert124NaraDigit(int num) {
        int convertNum = 0;

        switch(num) {
            case 1 :
            case 2 :
                convertNum = num;
                break;
            case 3 :
                convertNum = 4;
                break;
        }

        return Integer.toString(convertNum);
    }
    */

    /*
    //더 짧은 풀이 (속도는 느림)
    public String solution(int n) {
        String[] num = {"4","1","2"};

        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
    */

    //윗 버전에서 String 대신 StringBuffer 사용 -> Best
    public String solution(int n) {
        String[] num = {"4","1","2"};
        StringBuffer sb = new StringBuffer();

        while(n > 0){
            sb.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }
}