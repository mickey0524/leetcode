// https://leetcode.com/problems/sum-of-left-leaves/
//
// algorithms
// Easy (49.88%)
// Total Accepted: 145,814
// Total Submissions: 292,309
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    static int res;

    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;

        recursive(root, false);

        return res;
    }

    public void recursive(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (isLeft) {
                res += node.val;
            }
            return;
        }
        recursive(node.left, true);
        recursive(node.right, false);
    }
}