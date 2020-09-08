package question.leetcode.easy.range101to200;

// Best Time to Buy and Sell Stock
public class LP121 {
    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{7,6,4,3,1};
        int[] prices = new int[]{2,4,1};

        LP121 lp121 = new LP121();
        int result = lp121.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            int sell = prices[i];
            if(buy > sell) {
                buy = sell;
                profit = Math.max(profit, 0);
            }
            else {
                profit = Math.max(profit, sell-buy);
            }
        }

        return profit;
    }
}