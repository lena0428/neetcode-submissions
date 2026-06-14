class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] count = new int[26];
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (right - left - getMax(count) + 1 > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    private int getMax(int[] count) {
        int res = count[0];
        for (int c: count) {
            res = Math.max(res, c);
        }
        return res;
    }
}
