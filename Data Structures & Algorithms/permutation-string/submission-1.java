class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
  
        for (int right = 0; right < s2.length(); right++) {
            while (right - left + 1 > s1.length()) {
                left++;
            }
            if (checkSame(s1, s2.substring(left, right + 1))) {
                return true;
            }
        }
        return false;
    }

     public boolean checkSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
