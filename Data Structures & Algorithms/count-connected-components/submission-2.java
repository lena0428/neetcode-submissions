class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(-1, i, graph, visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int parent, int node, List<List<Integer>> graph, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int neighbor: graph.get(node)) {
            if (parent == neighbor) {
                continue;
            }
            dfs(node, neighbor, graph, visited);
        }
    }
}
