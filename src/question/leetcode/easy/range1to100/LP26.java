package question.leetcode.easy.range1to100;

//Remove Duplicates from Sorted Array
public class LP26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int[]{1,1,2};
        LP26 lp26 = new LP26();
        int length = lp26.removeDuplicates(nums);
        System.out.println(length);

        for(int i=0; i<length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int checkInt = nums[0];
        int targetIdx = 1;
        for(int i=1; i< nums.length; i++) {
            if(checkInt != nums[i]) {
                checkInt = nums[i];
                nums[targetIdx] = nums[i];
                targetIdx++;
            }
        }

        return targetIdx;
    }
}
