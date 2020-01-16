// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
//
// algorithms
// Easy (69.84%)
// Total Accepted: 66,221
// Total Submissions: 94,815


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> l = new ArrayList<>();

        recursive(l, root);

        return l;
    }

    public void recursive(ArrayList l, Node node) {
        if (node == null) {
            return;
        }

        for (Node n : node.children) {
            recursive(l, n);
        }
        l.add(node.val);
    }
}