class Solution {
    public int longestConsecutive(int[] nums) {
        // store all the nums
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        // go through the num in the set, find the start of the sequence
        int res = 0;
        for (int num: set) {
            int cnt = 0;
            int tmp = num;
            if (!set.contains(num - 1)) {
                while (set.contains(tmp)) {
                    tmp++;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
