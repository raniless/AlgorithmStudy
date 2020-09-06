package question.leetcode.easy.range101to200;

// Best Time to Buy and Sell Stock II
public class LP122 {
    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{1,2,3,4,5};
        int[] prices = new int[]{7,6,4,3,1};

        LP122 lp122 = new LP122();
        int result = lp122.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}
