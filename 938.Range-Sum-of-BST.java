// https://leetcode.com/problems/range-sum-of-bst/
//
// algorithms
// Easy (78.31%)
// Total Accepted: 112,848
// Total Submissions: 144,098


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private static int res;

    public int rangeSumBST(TreeNode root, int L, int R) {
        res = 0;

        recursive(root, L, R);

        return res;
    }

    public void recursive(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }

        recursive(root.left, L, R);
        if (root.val >= L && root.val <= R) {
            res += root.val;
        } else if (root.val > R) {
            return;
        }
        recursive(root.right, L, R);
    }
}