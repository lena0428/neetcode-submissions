class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return dfs(0, profit, weight, capacity);
    }

    public int dfs(int curIndex, List<Integer> profit, List<Integer> weight, int capacity) {
        if (curIndex == profit.size()) {
            return 0;
        }
        // skip cur index
        int maxProfit = dfs(curIndex + 1, profit, weight, capacity);

        // contains cur index
        int newCap = capacity - weight.get(curIndex);
        if (newCap >= 0) {
            int p = dfs(curIndex + 1, profit, weight, newCap) + profit.get(curIndex);
            maxProfit = Math.max(p, maxProfit);
        }
        return maxProfit;
    }
}
