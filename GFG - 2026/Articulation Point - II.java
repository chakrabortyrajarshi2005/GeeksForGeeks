Articulation Point - II
Difficulty: HardAccuracy: 55.15%Submissions: 43K+Points: 8Average Time: 30m
You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]

Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3.  
Constraints:
1 ≤ V, E ≤ 104class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] disc = new int[V], low = new int[V], parent = new int[V],
              childrenCount = new int[V];
        boolean[] visited = new boolean[V], ap = new boolean[V];
        for (int i = 0; i < V; i++) parent[i] = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                tarjan(i, adj, visited, disc, low, parent, childrenCount, ap);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (ap[i]) result.add(i);
        if (result.isEmpty()) result.add(-1);
        return result;
    }

    private static void tarjan(int start, ArrayList<ArrayList<Integer>> adj,
                               boolean[] visited, int[] disc, int[] low, int[] parent,
                               int[] childrenCount, boolean[] ap) {
        int n = adj.size();
        int[][] stack = new int[n * 2][3];
        int top = 0, time = 0;
        stack[top++] = new int[] {start, 0, 0};

        while (top > 0) {
            int u = stack[top - 1][0];
            int idx = stack[top - 1][1];
            int state = stack[top - 1][2];
            top--;

            if (state == 0) {
                if (!visited[u]) {
                    visited[u] = true;
                    disc[u] = low[u] = ++time;
                }

                if (idx < adj.get(u).size()) {
                    int v = adj.get(u).get(idx);
                    stack[top++] = new int[] {u, idx + 1, 0};
                    if (!visited[v]) {
                        parent[v] = u;
                        childrenCount[u]++;
                        stack[top++] = new int[] {v, 0, 0};
                    } else if (v != parent[u]) {
                        low[u] = Math.min(low[u], disc[v]);
                    }
                } else {
                    stack[top++] = new int[] {u, 0, 1};
                }
            } else {
                if (top > 0) {
                    int p = stack[top - 1][0];
                    low[p] = Math.min(low[p], low[u]);
                    if (parent[p] != -1 && low[u] >= disc[p]) ap[p] = true;
                } else if (childrenCount[start] > 1) {
                    ap[start] = true;
                }
            }
        }
    }
}
