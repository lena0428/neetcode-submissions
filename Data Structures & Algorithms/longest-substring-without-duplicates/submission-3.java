class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        // aabba
        HashMap<Character, Integer> charToIndexMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (charToIndexMap.containsKey(s.charAt(right))) {
                left = Math.max(left, charToIndexMap.get(s.charAt(right)) + 1);
            }
            res = Math.max(res, right - left + 1);
            charToIndexMap.put(s.charAt(right), right);
        }
        return res;
    }
}
