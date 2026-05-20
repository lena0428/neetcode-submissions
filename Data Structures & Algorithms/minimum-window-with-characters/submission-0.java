class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int[] count1 = new int[128];
        int[] count2 = new int[128];
        int len = s.length() + 1;
        String res = "";
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i)]++;
        }
        for (int right = 0; right < s.length(); right++) {
            count1[s.charAt(right)]++;
            while (contains(count1, count2)) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                count1[s.charAt(left)]--;
                left++;
            }
        }
        return res;
    }

    public boolean contains(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] < count2[i]) {
                return false;
            }
        }
        return true;
    }
}