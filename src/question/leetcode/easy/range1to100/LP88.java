package question.leetcode.easy.range1to100;

public class LP88 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};

        LP88 lp88 = new LP88();
        lp88.merge(num1, m, num2, n);

        for(int num : num1) {
            System.out.print(num + " ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int fillIdx = m+n-1;
        int num1Idx = m-1;
        int num2Idx = n-1;

        while(num1Idx >= 0 || num2Idx >= 0) {
            if(num1Idx < 0) {
                nums1[fillIdx--] = nums2[num2Idx--];
            }
            else if(num2Idx < 0) {
                nums1[fillIdx--] = nums1[num1Idx--];
            }
            else {
                if(nums1[num1Idx] > nums2[num2Idx]) {
                    nums1[fillIdx--] = nums1[num1Idx--];
                }
                else {
                    nums1[fillIdx--] = nums2[num2Idx--];
                }
            }
        }
    }
}
