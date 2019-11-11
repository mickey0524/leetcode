// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
//
// algorithms
// Easy (66.35%)
// Total Accepted: 73,257
// Total Submissions: 110,418
// beats 100.0% of java submissions


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {

    static int res;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        res = 1;

        recursive(root, 1);

        return res;
    }

    public void recursive(Node node, int depth) {
        if (node.children == null || node.children.size() == 0) {
            res = Math.max(res, depth);
            return;
        }

        for (Node c : node.children) {
            recursive(c, depth + 1);
        }
    }
}