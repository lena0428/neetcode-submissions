class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num: nums) {
            set.add(num);
        }
        for (int num: nums) {
            int cur = num;
            int tmp = 0;
            if (set.contains(cur)) {
                while (set.contains(cur)) {
                    cur++;
                    tmp++;
                }
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}
