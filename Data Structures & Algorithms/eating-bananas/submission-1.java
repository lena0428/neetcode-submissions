class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile: piles) {
                hours += Math.ceil(pile * 1.0 / mid);
            }
            if (hours <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int getMax(int[] piles) {
        int res = piles[0];
        for (int pile: piles) {
            res = Math.max(pile, res);
        }
        return res;
    }
}
