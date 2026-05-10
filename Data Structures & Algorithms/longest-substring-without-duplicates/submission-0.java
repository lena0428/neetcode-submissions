class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charToIndexMap = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // if contains, repeat
            if (charToIndexMap.containsKey(s.charAt(right))) {
                left = Math.max(charToIndexMap.get(s.charAt(right)) + 1, left);
            } 
            charToIndexMap.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
