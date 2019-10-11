// https://leetcode.com/problems/quad-tree-intersection/
//
// algorithms
// Easy (42.32%)
// Total Accepted: 6,306
// Total Submissions: 14,900
// beats 100.0% of java submissions

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null) {
            return quadTree2;
        } else if (quadTree2 == null) {
            return quadTree1;
        }

        Node n = null;
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            n = new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        } else if (!quadTree1.isLeaf && !quadTree2.isLeaf) {
            Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
                if (tl.val && tr.val && bl.val && br.val) {
                    n = new Node(true, true, null, null, null, null);
                } else if (!tl.val && !tr.val && !bl.val && !br.val) {
                    n = new Node(false, true, null, null, null, null);
                } else {
                    n = new Node(false, false, tl, tr, bl, br);
                }
            } else {
                n = new Node(false, false, tl, tr, bl, br);
            }
        } else if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                n = new Node(true, true, null, null, null, null);
            } else {
                n = quadTree2;
            }
        } else {
            if (quadTree2.val) {
                n = new Node(true, true, null, null, null, null);
            } else {
                n = quadTree1;
            }
        }

        return n;
    }
}