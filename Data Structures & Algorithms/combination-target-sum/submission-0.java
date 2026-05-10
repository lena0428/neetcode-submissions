    class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, 0, 0, target);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int index, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        if (sum > target) {
            return;
        }
        // choose index
        path.add(candidates[index]);
        backtrack(res, path, candidates, index , sum + candidates[index], target);
        // not choose index
        path.remove(path.size() - 1);
        backtrack(res, path, candidates, index + 1, sum, target);

    }
}
