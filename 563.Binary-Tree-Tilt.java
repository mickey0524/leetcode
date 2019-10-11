// https://leetcode.com/problems/binary-tree-tilt/
//
// algorithms
// Easy (47.30%)
// Total Accepted: 59,287
// Total Submissions: 125,349
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    static int res;

    public int findTilt(TreeNode root) {
        res = 0;

        recursive(root);

        return res;
    }

    public int recursive(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = recursive(node.left);
        int r = recursive(node.right);
        res += Math.abs(l - r);

        return node.val + l + r;
    }
}