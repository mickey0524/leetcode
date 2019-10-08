// https://leetcode.com/problems/max-area-of-island/
//
// algorithms
// Easy (34.58%)
// Total Accepted: 68,755
// Total Submissions: 198,827


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    static int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 1;
        recursive(root);

        return res - 1;
    }

    public int recursive(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = recursive(node.left);
        int right = recursive(node.right);
        int resTmp = 1;
        if (node.left != null && node.left.val == node.val) {
            resTmp += left;
            left++;
        } else {
            left = 0;
        }
        if (node.right != null && node.right.val == node.val) {
            resTmp += right;
            right++;
        } else {
            right = 0;
        }
        res = Math.max(resTmp, res);

        return Math.max(1, Math.max(left, right));
    }
}