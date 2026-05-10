class Solution {
    public int maxProfit(int[] prices) {
        int[][] profit = new int[2][prices.length];
        // 2: 0 -> not holding 
        //    1 -> holding
        //
        // prices.length -> day
        profit[0][0] = 0;
        profit[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[0][i] = Math.max(profit[0][i - 1], profit[1][i - 1] + prices[i]);
            // profit[0][i - 1]  must be 0 because we just can have a single buy, the sell must be future, not i - 1
            profit[1][i] = Math.max(profit[1][i - 1], 0 - prices[i]);
        }
        return profit[0][prices.length - 1];
    }
}
