class Solution {
    // 0         1    2     3
    // 1      2    3  .......
    // 2    3       2
    //
    //
    //
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backtrack(res, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
