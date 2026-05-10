class Solution {
    // 2
    //[] [2]
    // 5
    //[] [5]
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
        // choose
        path.add(nums[index]);
        sum+=nums[index];
        backtrack(res, path, nums, target, sum, index);
        // not choose
        path.remove(path.size() - 1);
        sum-=nums[index];
        backtrack(res, path ,nums, target, sum, index + 1);
    }
}
