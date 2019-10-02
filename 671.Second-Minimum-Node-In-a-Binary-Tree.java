// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
//
// algorithms
// Easy (43.13%)
// Total Accepted: 56,915
// Total Submissions: 131,971
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }

        long r = recursive(root, root.val);
        if (r == Long.MAX_VALUE) {
            return -1;
        }

        return (int) r;
    }

    public long recursive(TreeNode node, int minVal) {
        if (node.val > minVal) {
            return (long) node.val;
        }

        if (node.left != null) {
            return Math.min(recursive(node.left, minVal), recursive(node.right, minVal));
        }

        return Long.MAX_VALUE;
    }
}