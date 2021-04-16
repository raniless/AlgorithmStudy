package question.leetcode.easy.range1to100;

// Remove Element
//  - https://leetcode.com/problems/remove-element/
public class LP27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;

        LP27 lp27 = new LP27();
        int length = lp27.removeElement(nums, val);
        System.out.println(length);
        for(int i=0; i<length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }

        int targetIdx = 0;
        for(int i=0; i<nums.length; i++) {
            if(val != nums[i]) {
                nums[targetIdx++] = nums[i];
            }
        }

        return targetIdx;
    }
}
