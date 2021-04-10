package question.leetcode.medium.range1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find First and Last Position of Element in Sorted Array
// - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class LP34 {
    public static void main(String[] args) {
        LP34 lp34 = new LP34();
        List<LP34Test> tests = new ArrayList<>();
//        tests.add(new LP34Test(new int[]{5,7,7,8,8,10}, 8));
//        tests.add(new LP34Test(new int[]{5,7,7,8,8,10}, 6));
//        tests.add(new LP34Test(new int[]{}, 0));
        tests.add(new LP34Test(new int[]{1}, 1));

        for(LP34Test test : tests) {
            int[] answer = lp34.searchRange(test.getNums(), test.getTarget());
            System.out.println(Arrays.toString(answer));
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length-1;
        int first = -1;
        int last = -1;

        //같은 값의 시작 지점을 이분 탐색으로 Search
        while(start <= end) {
            int mid = (start + end) / 2;

            //같은 값을 찾은 경우 좌우로 이동하면서 first, last를 찾음
            if(nums[mid] == target) {
                first = mid;
                last = mid;

                while(first > start) {
                    if(nums[first-1] == target) {
                        first--;
                    } else {
                        break;
                    }
                }

                while(last < end) {
                    if(nums[last+1] == target) {
                        last++;
                    } else {
                        break;
                    }
                }

                break;
            }
            else if(nums[mid] > target) {
                end = mid-1;
            }
            else if(nums[mid] < target) {
                start = mid+1;
            }

        }

        return new int[]{first, last};
    }

    static class LP34Test {
        private int nums[];
        private int target;

        public LP34Test(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        public int[] getNums() {
            return nums;
        }

        public void setNums(int[] nums) {
            this.nums = nums;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }
    }
}
