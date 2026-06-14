class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, candidates, target, 0, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int index, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        // choose i
        path.add(candidates[index]);
        backtrack(res, path, candidates, target, index + 1, sum + candidates[index]);
        // not choose i
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        path.remove(path.size() - 1);
        backtrack(res, path, candidates, target, index + 1, sum);
    }
}
