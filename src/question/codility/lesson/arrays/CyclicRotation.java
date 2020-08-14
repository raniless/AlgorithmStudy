package question.codility.lesson.arrays;

public class CyclicRotation {
    public static void main(String[] args) {
//        int[] A = new int[]{3,8,9,7,6};
//        int K = 3;

        int[] A = new int[]{1,2,3,4};
        int K = 4;

        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] result = cyclicRotation.solution(A, K);

        for(int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++) {
            int idx = (i+K) % A.length;
            result[idx] = A[i];
        }

        return result;
    }
}
