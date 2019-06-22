// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//
// algorithms
// Medium (38.17%)
// Total Accepted: 249,105
// Total Submissions: 652,624
// beats 100.0% of java submissions

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> q = new LinkedList<>();
        Node last = null;
        q.add(root);
        q.add(null);

        while (true) {
            Node curNode = q.pollFirst();
            if (curNode == null) {
                if (q.size() == 0) {
                    break;
                }
                q.add(null);
                last = null;
            } else {
                if (curNode.left != null) {
                    if (last != null) {
                        last.next = curNode.left;
                    }
                    q.offerLast(curNode.left);
                    q.offerLast(curNode.right);
                    curNode.left.next = curNode.right;
                    last = curNode.right;
                }
            }
        }

        return root;
    }
}