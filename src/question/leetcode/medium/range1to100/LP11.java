package question.leetcode.medium.range1to100;

// Container With Most Water
//  - https://leetcode.com/problems/container-with-most-water/
public class LP11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};

        LP11 lp11 = new LP11();
        int result = lp11.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int ans = 0;

        int left = 0;
        int right = height.length-1;

        while(left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right-left));

            if(height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return ans;
    }

    /* Worst Case
    public int maxArea(int[] height) {
        int ans = 0;

        for(int i=0; i<height.length; i++) {
            int line = height[i];

            int j = 0;
            while(line * (i-j) > ans && j<i) {
                ans = Math.max(ans, Math.min(line, height[j]) * (i-j));
                j++;
            }

            j = height.length-1;
            while(line * (j-i) > ans && j>i) {
                ans = Math.max(ans, Math.min(line, height[j]) * (j-i));
                j--;
            }
        }

        return ans;
    }
    */
}
