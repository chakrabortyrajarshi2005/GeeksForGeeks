Predecessor and Successor
Difficulty: MediumAccuracy: 47.36%Submissions: 188K+Points: 4
You are given the root of a BST and an integer key. You need to find the inorder predecessor and successor of the given key. If either predecessor or successor is not found, then set it to NULL.

Note: In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

Examples :

Input: root = [50, 30, 70, 20, 40, 60, 80], key = 65

Output: [60, 70]
Explanation: In the given BST the inorder predecessor of 65 is 60 and inorder successor of 65 is 70.

Input: root = [8, 1, 9, N, 4, N, 10, 3], key = 8

Output: [4, 9]
Explanation: In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.

Constraints: 
1 ≤ no. of nodes ≤ 105
0 ≤ node->data ≤ 106
1 ≤ key ≤ 106

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public Node rightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node leftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;

        while (curr != null) {
            if (curr.data < key) {
                pre = curr;

                curr = curr.right;
            } else if (curr.data > key) {
                suc = curr;

                curr = curr.left;
            } else {
                if (curr.left != null) pre = rightMost(curr.left);
                if (curr.right != null) suc = leftMost(curr.right);
                break;
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        result.add(pre);
        result.add(suc);
        return result;
    }
}
