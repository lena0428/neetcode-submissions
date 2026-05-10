class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjacent, visited, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(List<List<Integer>> adjacent, boolean[] visited, int v) {
        visited[v] = true;
        for (int neighbor: adjacent.get(v)) {
            if (visited[neighbor]) {
                continue;
            }
            dfs(adjacent, visited, neighbor);
        }
    }
}
