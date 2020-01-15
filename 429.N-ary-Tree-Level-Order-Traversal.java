// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
//
// algorithms
// Medium (61.87%)
// Total Accepted: 56,042
// Total Submissions: 90,585


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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> level = new ArrayList<>();

        while (q.size() > 0) {
            Node cur = q.pollFirst();
            if (cur == null) {
                res.add(level);
                if (q.size() > 0) {
                    level = new ArrayList<>();
                    q.offer(null);
                }
            } else {
                level.add(cur.val);
                for (Node n : cur.children) {
                    q.offer(n);
                }
            }
        }

        return res;
    }
}