class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // ignore non letters and non numbers
            while (left < right && (!Character.isDigit(s.charAt(left)) && !Character.isAlphabetic(s.charAt(left)))) {
                left++;
            }
            while (left < right && (!Character.isDigit(s.charAt(right)) && !Character.isAlphabetic(s.charAt(right)))) {
                right--;
            }
            if (Character.toUpperCase(s.charAt(left))!= Character.toUpperCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
