class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] existed = new int[26];
        for (int i = 0; i < s.length(); i++) {
            existed[s.charAt(i) - 'a']++;
            existed[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (existed[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
