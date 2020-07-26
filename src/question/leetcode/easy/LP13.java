package question.leetcode.easy;

//Roman to Integer
public class LP13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        LP13 lp13 = new LP13();
        int result = lp13.romanToInt(s);
        System.out.println(result);
    }

    public int romanToInt(String s) {
        int sum = 0;

        for(int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);

            int value = getSymbolValue(ch);

            if('I' == ch || 'X' == ch || 'C' == ch) {
                if(i < s.length() -1) {
                    char rightCh = s.charAt(i+1);

                    if('I' == ch && ('V' == rightCh || 'X' == rightCh)) {
                        value = -1;
                    }
                    else if('X' == ch && ('L' == rightCh || 'C' == rightCh)) {
                        value = -10;
                    }
                    else if('C' == ch && ('D' == rightCh || 'M' == rightCh)) {
                        value = -100;
                    }
                }
            }

            sum += value;
        }

        return sum;
    }

    private int getSymbolValue(char ch) {
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
