package question.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 키패드 누르기
public class PG67256 {
    public static void main(String[] args) {
        List<PG67256Test> tests = new ArrayList<>();
        tests.add(new PG67256Test(new int[]{1,3,4,5,8,2,1,4,5,9,5}, "right"));
        tests.add(new PG67256Test(new int[]{7,0,8,2,8,3,1,5,7,6,2}, "left"));
        tests.add(new PG67256Test(new int[]{1,2,3,4,5,6,7,8,9,0}, "right"));

        PG67256 pg67256 = new PG67256();
        for(PG67256Test test : tests) {
            String answer = pg67256.solution(test.getNumbers(), test.getHand());
            System.out.println(answer);
        }
    }

    public String solution(int[] numbers, String hand) {
        Map<String, int[]> keypad= new HashMap<>();
        keypad.put("1", new int[]{1,1});
        keypad.put("2", new int[]{1,2});
        keypad.put("3", new int[]{1,3});
        keypad.put("4", new int[]{2,1});
        keypad.put("5", new int[]{2,2});
        keypad.put("6", new int[]{2,3});
        keypad.put("7", new int[]{3,1});
        keypad.put("8", new int[]{3,2});
        keypad.put("9", new int[]{3,3});
        keypad.put("*", new int[]{4,1});
        keypad.put("0", new int[]{4,2});
        keypad.put("#", new int[]{4,3});

        String curLeft = "*";
        String curRight = "#";

        String answer = "";
        for(int number :numbers) {
            if(number == 1 || number == 4 || number == 7) {
                answer += "L";
                curLeft = String.valueOf(number);
            }
            else if(number == 3 || number == 6 || number == 9) {
                answer += "R";
                curRight = String.valueOf(number);
            }
            else {
                int[] numberPos = keypad.get(String.valueOf(number));
                int[] leftPos = keypad.get(curLeft);
                int[] rightPos = keypad.get(curRight);

                int leftDist = Math.abs(numberPos[0] - leftPos[0]) + Math.abs(numberPos[1] - leftPos[1]);
                int rightDist = Math.abs(numberPos[0] - rightPos[0]) + Math.abs(numberPos[1] - rightPos[1]);

                if(leftDist == rightDist) {
                    if("left".equals(hand)) {
                        answer += "L";
                        curLeft = String.valueOf(number);
                    }
                    else {
                        answer += "R";
                        curRight = String.valueOf(number);
                    }
                }
                else if(leftDist > rightDist) {
                    answer += "R";
                    curRight = String.valueOf(number);
                }
                else {
                    answer += "L";
                    curLeft = String.valueOf(number);
                }
            }
        }

        return answer;
    }

    static class PG67256Test {
        private int[] numbers;
        private String hand;

        public PG67256Test(int[] numbers, String hand) {
            this.numbers = numbers;
            this.hand = hand;
        }

        public int[] getNumbers() {
            return numbers;
        }

        public String getHand() {
            return hand;
        }
    }
}
