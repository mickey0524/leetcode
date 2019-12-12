// https://leetcode.com/problems/cousins-in-binary-tree/
//
// algorithms
// Medium (51.97%)
// Total Accepted: 33,322
// Total Submissions: 64,113
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static TreeNode parentX;
    private static TreeNode parentY;
    private static int levelX;
    private static int levelY;

    public boolean isCousins(TreeNode root, int x, int y) {
        parentX = null;
        parentY = null;
        levelX = -1;
        levelY = -1;

        recursive(root, null, x, y, 0);

        if (levelX != levelY) {
            return false;
        }

        if (parentX == parentY) {
            return false;
        }

        return true;
    }

    private void recursive(TreeNode root, TreeNode parent, int x, int y, int level) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentX = parent;
            levelX = level;
        }

        if (root.val == y) {
            parentY = parent;
            levelY = level;
        }

        recursive(root.left, root, x, y, level + 1);
        recursive(root.right, root, x, y, level + 1);
    }
}