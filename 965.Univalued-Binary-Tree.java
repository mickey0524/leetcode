// https://leetcode.com/problems/univalued-binary-tree/
//
// algorithms
// Easy (66.96%)
// Total Accepted: 60,518
// Total Submissions: 90,384
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static boolean res;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        res = true;
        recursive(root, root.val);

        return res;
    }

    public void recursive(TreeNode root, int value) {
        if (root == null || !res) {
            return;
        }

        if (root.val != value) {
            res = false;
            return;
        }

        recursive(root.left, value);
        recursive(root.right, value);
    }

}