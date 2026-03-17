Burning Tree
Difficulty: HardAccuracy: 53.53%Submissions: 140K+Points: 8
Given the root of a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.

Note: The tree contains unique values.

Examples : 

Input: root = [1, 2, 3, 4, 5, 6, 7], target = 2
  
Output: 3
Explanation: Initially 2 is set to fire at 0 sec 
At 1 sec: Nodes 4, 5, 1 catches fire.
At 2 sec: Node 3 catches fire.
At 3 sec: Nodes 6, 7 catches fire.
It takes 3s to burn the complete tree.
Input: root = [1, 2, 3, 4, 5, N, 7, 8, N, N, 10], target = 10

Output: 5
Explanation: Initially 10 is set to fire at 0 sec 
At 1 sec: Node 5 catches fire.
At 2 sec: Node 2 catches fire.
At 3 sec: Nodes 1 and 4 catches fire.
At 4 sec: Node 3 and 8 catches fire.
At 5 sec: Node 7 catches fire.
It takes 5s to burn the complete tree.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

Expected Complexities
class Solution {
    public int minTime(Node root, int target) {

        if (root == null) return -1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node tar = null;

        Map<Node, Node> par = new HashMap<>();
        par.put(root, null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == target) tar = curr;

            if (curr.left != null) {
                par.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                par.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        Map<Node, Boolean> vis = new HashMap<>();
        int ans = -1;
        q.add(tar);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.poll();
                vis.put(curr, true);

                if (curr.left != null && !vis.containsKey(curr.left)) q.add(curr.left);

                if (curr.right != null && !vis.containsKey(curr.right))
                    q.add(curr.right);

                if (par.get(curr) != null && !vis.containsKey(par.get(curr)))
                    q.add(par.get(curr));
            }
            ans++;
        }

        return ans;
    }
}
