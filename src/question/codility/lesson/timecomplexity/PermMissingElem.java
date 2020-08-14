package question.codility.lesson.timecomplexity;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,1,5};

        PermMissingElem permMissingElem = new PermMissingElem();
        int result = permMissingElem.solution(A);
        System.out.println(result);
    }

    public int solution(int[] A) {
        int total = A.length+1;
        int sum = 0;

        for(int i=0; i<A.length; i++) {
            sum += A[i];
            total += (i+1);
        }

        return total - sum;
    }
}
