package question.programmers.level1;

import java.util.*;

// [1차] 다트 게임
public class PG17682 {
    public static void main(String[] args) {
        List<String> tests = new ArrayList<>();
        tests.add("1S2D*3T");
        tests.add("1D2S#10S");
        tests.add("1D2S0T");
        tests.add("1S*2T*3S");
        tests.add("1D#2S*3S");
        tests.add("1T2D3D#");
        tests.add("1D2S3T*");

        PG17682 pg17682 = new PG17682();
        for(String dartResult : tests) {
            int answer = pg17682.solution(dartResult);
            System.out.println(answer);
        }
    }

    public int solution(String dartResult) {
        Map<String, Integer> optionMap = new HashMap<>();
        optionMap.put("S", 1);
        optionMap.put("D", 2);
        optionMap.put("T", 3);

        int[] nums = new int[4];
        Map<Integer, String> numOptions = new HashMap<>();

        int numOrder = 0;
        int digitCnt = 0;
        for(int i=0; i<dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if(Character.isDigit(ch)) {
                digitCnt++;
                continue;
            }

            String str = Character.toString(ch);
            if(optionMap.containsKey(str)) {
                numOrder++;
                int num = Integer.parseInt(dartResult.substring(i-digitCnt, i));
                nums[numOrder] = (int)Math.pow(num, optionMap.get(str));
                digitCnt = 0;
            }
            else {
                numOptions.put(numOrder, str);
            }
        }

        for(Map.Entry<Integer, String> entry : numOptions.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();

            if("*".equals(value)) {
                nums[key] *= 2;

                if(key > 1) {
                    nums[key-1] *= 2;
                }
            }
            else if("#".equals(value)) {
                nums[key] *= -1;
            }
        }

        return nums[1] + nums[2] + nums[3];
    }
}
