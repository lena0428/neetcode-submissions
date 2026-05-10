class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        // update the left when need to change more than k characters
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (right - left + 1 - findMax(count) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int findMax(int[] count) {
        int res = count[0];
        for(int c: count) {
            res = Math.max(res, c);
        }
        return res;
    }
}
