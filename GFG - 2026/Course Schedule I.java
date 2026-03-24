Course Schedule I
Difficulty: MediumAccuracy: 68.62%Submissions: 12K+Points: 4
You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y] indicates that we need to take course y first if we want to take course x.

Find if it is possible to complete all tasks. Return true if all tasks can be completed, or false if it is impossible.

Examples:

Input n = 4, prerequisites[] = [[2, 0], [2, 1], [3, 2]]
Output: true
Explanation: 
To take course 2, you must first finish courses 0 and 1.
To take course 3, you must first finish course 2.
All courses can be completed, for example in the order [0, 1, 2, 3] or [1, 0, 2, 3].
Input: n = 3, prerequisites[] = [[0, 1], [1, 2], [2, 0]]
Output: false
Explanation: 
To take course 0, you must first finish course 1. 
To take course 1, you must first finish course 2. 
To take course 2, you must first finish course 0.
Since each course depends on the other, it is impossible to complete all courses.
Constraints:
1 ≤ n ≤ 104
0 ≤ prerequisites.size() ≤ 105
0 ≤ prerequisites[i][0], prerequisites[i][1] < n
All prerequisite pairs are unique
prerequisites[i][0] ≠ prerequisites[i][1]
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : graph.get(node)) {
                inDegree[child]--;
                if (inDegree[child] == 0) q.add(child);
            }
        }

        for (int i = 0; i < n; i++)
            if (inDegree[i] != 0) return false;

        return true;
    }
}
