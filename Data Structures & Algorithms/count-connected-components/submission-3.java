class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
           if (!visited.contains(i)) {
            res++;
            dfs(-1, i, visited, graph);
           } 
        }
        return res;
    }

    public void dfs(int parent, int node, HashSet<Integer> visited, List<List<Integer>> graph) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int neighbor: graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            dfs(node, neighbor, visited, graph);
        }
    }
}
