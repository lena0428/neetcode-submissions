class Solution {
    //   0   (
    //   1   )  cannot (
    //
    //  0   (
    //  1   (  )
    // 2   )    (
    // 3   )     )
    ///
    //
    //  4^n time
    //     space  n call stack
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public void generate(List<String> res, String path, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(new String(path));
            return;
        }
        if (left < n) {
            path+='(';
            generate(res, path, left + 1, right, n);
            path = path.substring(0, path.length() - 1);
        }
        if (right < left) {
            path+=')';
            generate(res, path, left, right + 1, n);
            path = path.substring(0, path.length() - 1);

        }
    }
}
