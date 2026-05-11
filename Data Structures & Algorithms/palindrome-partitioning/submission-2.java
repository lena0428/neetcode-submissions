class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    public void backtrack(List<List<String>> res, List<String> path, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isValid(s.substring(index, i + 1))) {
                path.add(s.substring(index, i + 1));
                backtrack(res, path, s, i + 1);
                path.remove(path.size() - 1);
            } 
        }
    }

    public boolean isValid(String s) {
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
