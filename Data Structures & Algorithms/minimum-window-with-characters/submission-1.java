class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int[] count1 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            count1[t.charAt(i)]++;
        }
        int res = s.length() + 1;
        String resStr = "";
        int[] count2 = new int[128];
        for (int right = 0; right < s.length(); right++) {
            count2[s.charAt(right)]++;
            while (contains(count1, count2)) {
                if (res > right - left + 1) {
                    res = right - left + 1;
                    resStr = s.substring(left, right + 1);
                }
                count2[s.charAt(left)]--;
                left++;
            }
        }
        return resStr;
    }

    public boolean contains(int[] count1, int[] count2) {
        for (int i = 0; i < 128; i++) {
            if (count1[i] > count2[i]) {
                return false;
            }
        }
        return true;
    }
}
