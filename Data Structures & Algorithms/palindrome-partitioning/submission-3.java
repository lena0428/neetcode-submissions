class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, s);
        return res;
    }

    public void backtrack(List<List<String>> res, List<String> path, int index, String s) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // put , after i
        for (int i = index; i < s.length(); i++) {
            if (!isPalindrome(s.substring(index, i + 1))) {
                continue;
            }
            path.add(s.substring(index, i + 1));
            backtrack(res, path, i + 1, s);
            path.remove(path.size() - 1);
        }
    }

     public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
         while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
