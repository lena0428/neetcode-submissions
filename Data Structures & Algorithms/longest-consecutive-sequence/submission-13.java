class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = 0;
        for (int i: set) {
            // from start number
            if (!set.contains(i - 1)) {
                int tmp = i;
                int len = 0;
                while (set.contains(tmp)) {
                    tmp++;
                    len++;
                }
                res = Math.max(len, res);
            }
        }
        return res;
    }
}
