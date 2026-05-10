class Solution {
    // n = 2
    // (
    // (( 
    // left > right
    // if (left == n) need to add right
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "" , n, 0, 0);
        return res;
    }

    public void generate(List<String> res, String path, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(new String(path));
            return;
        }
        if (left < n) {
            path+="(";
            generate(res, path, n, left + 1, right);
            path = path.substring(0, path.length() - 1);
        }
        if (left > right) {
            path+=")";
            generate(res, path, n, left, right + 1);
            path = path.substring(0, path.length() - 1);
        }
    }
}
