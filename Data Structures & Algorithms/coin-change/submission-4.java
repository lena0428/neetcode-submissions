class Solution {
    int minCoin = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0, 0, new ArrayList<>());
        if (minCoin == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minCoin;
        }
    }

    public void dfs(int[] coins, int amount, int sum, int index, List<Integer> path) {
        if (amount < sum) {
            return;
        }
        if (amount == sum) {
            minCoin = Math.min(minCoin, path.size());
            return;
        }
        if (index == coins.length) {
            return;
        }
        // choose coin
        path.add(coins[index]);
        sum+=coins[index];
        dfs(coins, amount, sum, index, path);
        // not choose
        path.remove(path.size() - 1);
        sum-=coins[index];
        dfs(coins, amount, sum, index + 1, path);
    }
}
