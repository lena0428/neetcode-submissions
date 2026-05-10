class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1 2 3 11 h must be >= pile number
        // k = 11 -> h = 4
        // k = 3 -> h > 4
        // [1, 2, 3 ... 11]
        int res = 0;
        int left = 1;
        int right = getMax(piles);
        while (left <= right) {
            int k = left + (right - left) / 2;
            int hours = 0;
            for (int pile: piles) {
                hours += Math.ceil((double) pile / k);
            }
            // should be faster
            if (h < hours) {
                left = k + 1;
            } else {
                res = k;
                right = k - 1;
            }
        }
        return res;
    }

    public int getMax(int[] piles) {
        int res = piles[0];
        for (int i = 0; i < piles.length; i++) {
            res = Math.max(res, piles[i]);
        }
        return res;
    }
}
