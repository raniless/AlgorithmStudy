package question.leetcode.medium.range1to100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Longest Substring Without Repeating Characters
//  - https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LP3 {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
        LP3 lp3 = new LP3();
        int result = lp3.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    //Sliding Window Optimized - O(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j=0, i=0; j<n; j++) {
            Character ch = s.charAt(j);
            if(map.containsKey(ch)) {
                i = Math.max(map.get(ch), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(ch, j+1);
        }

        return ans;
    }

    /*
    //Brute Force - O(n^3)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                if(allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();

        for(int i=start; i<end; i++) {
            Character ch = s.charAt(i);
            if(set.contains(ch)) {
                return false;
            }

            set.add(ch);
        }

        return true;
    }
    */

    /*
    //Sliding Window - O(n) ~ O(2n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i < n && j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }
    */
}