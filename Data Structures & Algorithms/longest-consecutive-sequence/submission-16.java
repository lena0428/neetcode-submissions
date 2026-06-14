class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        for (int num: nums) {
            int tmp = num;
            int len = 0;
            while (set.contains(tmp)) {
                tmp++;
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
