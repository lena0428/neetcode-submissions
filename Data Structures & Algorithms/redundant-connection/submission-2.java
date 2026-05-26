class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            visited = new HashSet<>();
            if (!dfs(-1, edge[0], visited, graph)) {
                return edge;
            }
        }
        return new int[0];
    }


    public boolean dfs(int parent, int node, HashSet<Integer> visited, List<List<Integer>> graph) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int neighbor: graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (!dfs(node, neighbor, visited, graph)) {
                return false;
            }
        }
        return true;
    }
}
