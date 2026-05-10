class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = 0;
        for (int num: nums) {
            int tmp = 0;
            int cur = num;
            while (set.contains(cur)) {
                cur++;
                tmp++;
            }
            res = Math.max(tmp, res);
        }
        return res;
    }
}
