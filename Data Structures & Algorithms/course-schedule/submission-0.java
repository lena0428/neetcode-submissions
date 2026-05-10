class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] edges = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            // prerequisite[1] -> prerequisite[0]
            graph.get(prerequisite[1]).add(prerequisite[0]);
            edges[prerequisite[0]]++;
        }
        // use queue to solve this problem, if a vertex in this graph doesn't have other vertex
        // point to it, add into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (edges[i] == 0) {
                queue.offer(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            cnt++;
            List<Integer> neighbours = graph.get(tmp);
            for (int neighbour: neighbours) {
                edges[neighbour]--;
                if (edges[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        return cnt == numCourses;
    }
}
