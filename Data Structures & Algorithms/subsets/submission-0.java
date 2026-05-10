class Solution {
    // 1
    //[] [1] choose or not choose
    //2
    //[] [2] choose or not choose
    //3
    //[] [3] choose or not choose
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        // reach to the leaf
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // choose
        path.add(nums[index]);
        backtrack(res, path, nums, index + 1);
        // not choose
        path.remove(path.size() - 1);
        backtrack(res, path, nums, index + 1);
    }
}
