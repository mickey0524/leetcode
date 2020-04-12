// https://leetcode-cn.com/problems/binode-lcci/
// algorithms
// Easy (59.22%)
// Total Accepted: 2,171
// Total Submissions: 3,666


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private TreeNode res;
    private TreeNode pre;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        res = null;
        pre = null;

        recursive(root);
        pre.left = null;
        pre.right = null;

        return res;
    }

    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }

        recursive(node.left);

        if (res == null) {
            res = node;
        } else {
            pre.left = null;
            pre.right = node;
        }
        pre = node;

        recursive(node.right);
    }
}