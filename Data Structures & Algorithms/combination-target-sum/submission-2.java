class Solution {
    //             2            5        6        9
    //         [2]  []       [5]  []   6   [6]
    // 
    //   0   [2]   []
    //   1  [5][] [5] []/[2][] [2][]
    //   2 ....
    //
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, target, 0, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int target, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index == nums.length) {
            return;
        }
        // choose nums[index]
        path.add(nums[index]);
        backtrack(res, path, nums, target, sum + nums[index], index);
        // don't choose nums[index]
        path.remove(path.size() - 1);
        backtrack(res, path, nums, target, sum, index + 1);
    }
}
