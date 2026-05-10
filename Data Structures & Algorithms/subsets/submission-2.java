class Solution {
    //       1 2 3
    //          1       
    //  0    [1]    [] 
    //  1  [2] [] [2] []
    //  2 [3] [] [3] []
    //.....
    //  [1,2,3] [1,2] [1] [1,3].....
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // choose nums[index]
        path.add(nums[index]);
        backtrack(nums, index + 1, path, res);
        // don't choose nums[index]
        path.remove(path.size() - 1);
        backtrack(nums, index + 1, path, res);
    }
}
