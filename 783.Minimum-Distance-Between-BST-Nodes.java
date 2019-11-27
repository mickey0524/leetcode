// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
//
// algorithms
// Easy (51.08%)
// Total Accepted: 44,609
// Total Submissions: 87,338
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    static int res = Integer.MAX_VALUE;
    static int pre = -1;

    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        recursive(root);

        return res;
    }

    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }

        recursive(node.left);
        if (pre != -1) {
            res = Math.min(node.val - pre, res);
        }
        pre = node.val;
        recursive(node.right);
    }

}