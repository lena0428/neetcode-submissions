class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            if (charToIndex.containsKey(s.charAt(right))) {
                left = Math.max(left, charToIndex.get(s.charAt(right)) + 1);
            }
            charToIndex.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
