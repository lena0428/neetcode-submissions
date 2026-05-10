class Solution {
    // xxaxx -> a xxxxx
    // maxcount of character
    // right - left - maxcount <= k
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (right - left - getMax(count) + 1> k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int getMax(int[] count) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, count[i]);
        }
        return res;
     }
}
