package question.codility.lesson.iteration;

public class BinaryGap {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(n);
        System.out.println(result);
    }

    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        int gapSize = 0;
        int maxGapSize = 0;
        for(int i=0; i<binary.length(); i++) {
            int bit = Character.digit(binary.charAt(i), 10);
            if(bit == 1) {
                maxGapSize = Math.max(maxGapSize, gapSize);
                gapSize = 0;
            }
            else {
                gapSize++;
            }
        }

        return maxGapSize;
    }
}
