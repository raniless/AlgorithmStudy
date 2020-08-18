package question.codility.lesson.timecomplexity;

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = new int[]{3,1,2,4,3};

        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int result = tapeEquilibrium.solution(A);
        System.out.println(result);
    }

    public int solution(int[] A) {
        int totalSum = 0;
        for(int i=0; i<A.length; i++) {
            totalSum += A[i];
        }

        int minDiff = Integer.MAX_VALUE;
        int leftSum = 0;
        for(int i=0; i<A.length-1; i++) {
            leftSum += A[i];
            int absDiff = Math.abs(leftSum - (totalSum-leftSum));

            minDiff = Math.min(minDiff, absDiff);
        }

        return minDiff;
    }
}
