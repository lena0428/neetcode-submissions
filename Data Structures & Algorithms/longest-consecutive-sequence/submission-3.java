class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int length = 1;
        for (int num: nums) {
            int tmp = 1;
            if (set.contains(num + 1)) {
                int key = num + 1;
                while (set.contains(key)) {
                    key++;
                    tmp++;
                }
                length = Math.max(length, tmp);
            }
        }
        return length;
    }
}
