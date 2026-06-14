class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        backtrack(res, path, nums, index + 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        path.remove(path.size() - 1);
        backtrack(res, path, nums, index + 1);
    }
}
