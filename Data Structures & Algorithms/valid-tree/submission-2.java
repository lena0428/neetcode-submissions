class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        if (isCycle(-1, 0, adjacent, visited)) {
            return false;
        }
        return visited.size() == n;
    }

    public boolean isCycle(int source, int v, List<List<Integer>> adjacent, Set<Integer> visited) {
        visited.add(v);
        for (int neighbor: adjacent.get(v)) {
            if (visited.contains(neighbor)) {
                if (neighbor != source) {
                    return true;
                }
            } else {
                if (isCycle(v, neighbor, adjacent, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
