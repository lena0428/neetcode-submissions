class Solution {
    public int characterReplacement(String s, int k) {
        // left, right
        // right go through the s
        // at most k
        // update left when right - left + 1 - maxappear > k
        // update length as well
        int length = 0;
        int left = 0;
        int[] count = new int[26];
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (right - left + 1 - getMax(count) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            length = Math.max(right - left + 1, length);
        }
        return length;
    }
    
    public int getMax(int[] count) {
        int res = count[0];
        for (int i = 0; i < count.length; i++) {
            res = Math.max(res, count[i]);
        }
        return res;
    }
}
