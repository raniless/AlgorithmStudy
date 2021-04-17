package question.leetcode.easy.range101to200;

// Excel Sheet Column Title
// - https://leetcode.com/problems/excel-sheet-column-title/
public class LP168 {
     public static void main(String[] args) {
        int n = 701;

        LP168 lp168 = new LP168();
        String result = lp168.convertToTitle(n);
        System.out.println(result);
    }

    public String convertToTitle(int n) {
        if(n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            //1을 빼서 0~25를 만들고 26진법을 활용
            n--;
            sb.append((char)('A' + (n%26)));
            n /= 26;
        }

        return sb.reverse().toString();
    }

    /*
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int mod = n % 26;
            if(mod == 0) {
                sb.append("Z");
                n = (n / 26) - 1;
            }
            else {
                sb.append((char)(mod - 1 + 'A'));
                n = n / 26;
            }
        }

        return sb.reverse().toString();
    }
    */
}