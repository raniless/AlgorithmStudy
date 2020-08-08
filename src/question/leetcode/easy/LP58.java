package question.leetcode.easy;

//Length of Last Word
public class LP58 {
    public static void main(String[] args) {
//        String s = "Hello World";
        String s = "a ";
        LP58 lp58 = new LP58();
        int length = lp58.lengthOfLastWord(s);
        System.out.println(length);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();

        if(s.length() == 0) {
            return 0;
        }

        if(s.lastIndexOf(" ") == -1) {
            return s.length();
        }

        int lastSpaceIdx = s.lastIndexOf(" ");
        return s.substring(lastSpaceIdx+1, s.length()).length();
    }
}