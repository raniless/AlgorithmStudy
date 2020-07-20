package question.leetcode.easy;

//Two Sum
/*
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class Question1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Question1 question1 = new Question1();
        int[] answer = question1.twoSum(nums, target);
        System.out.println(answer);
    }
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }
}
