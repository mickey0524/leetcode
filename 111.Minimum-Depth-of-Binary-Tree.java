// https://leetcode.com/problems/minimum-depth-of-binary-tree/
//
// algorithms
// Easy (36.41%)
// Total Accepted: 356,218
// Total Submissions: 978,343
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static int res;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = Integer.MAX_VALUE;

        recursive(root, 0);

        return res;
    }

    private void recursive(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            res = Math.min(res, level + 1);
            return;
        }

        if (node.left != null) {
            recursive(node.left, level + 1);
        }

        if (node.right != null) {
            recursive(node.right, level + 1);
        }
    }
}