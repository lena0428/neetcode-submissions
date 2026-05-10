class Solution {
    public int maxProfit(int[] prices) {
        int[][] profit = new int[2][prices.length];
        // 0 -> sell
        // 1 -> buy
        profit[0][0] = 0;
        // choose a single day to buy, could buy at first day
        profit[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[0][i] = Math.max(profit[1][i - 1] + prices[i], profit[0][i - 1]);
            profit[1][i] = Math.max(-prices[i], profit[1][i - 1]);
        }
        return profit[0][prices.length - 1];
    }
}
