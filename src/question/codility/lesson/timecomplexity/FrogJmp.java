package question.codility.lesson.timecomplexity;

public class FrogJmp {
    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;

        FrogJmp frogJmp = new FrogJmp();
        int result = frogJmp.solution(X, Y, D);
        System.out.println(result);
    }

    public int solution(int X, int Y, int D) {
        int portion = (Y-X)/D;
        int mod = (Y-X)%D;

        return mod == 0 ? portion : portion+1;
    }
}
