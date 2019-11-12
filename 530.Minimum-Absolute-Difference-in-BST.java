// https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//
// algorithms
// Easy (51.76%)
// Total Accepted: 70,652
// Total Submissions: 136,495
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    static int res;
    static int pre;

    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;

        recursive(root);

        return res;
    }

    public void recursive(TreeNode root) {
        if (root == null) {
            return;
        }

        recursive(root.left);
        if (pre != -1) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        recursive(root.right);
    }
}