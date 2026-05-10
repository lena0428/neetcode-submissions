class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = 0;
        for (int num: nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 0;
            int tmp = num;
            while (set.contains(tmp)) {
                tmp++;
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
