// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
// algorithms
// Medium (48.11%)
// Total Accepted: 2,833
// Total Submissions: 5,888
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static int res;
    private static final int LEFT = 1;
    private static final int RIGHT = -1;

    public int longestZigZag(TreeNode root) {
        res = 0;

        recursive(root.left, LEFT, 0);
        recursive(root.right, RIGHT, 0);

        return res;
    }

    private void recursive(TreeNode node, int direction, int curSum) {
        if (node == null) {
            res = Math.max(res, curSum);
            return;
        }

        if (direction == LEFT) {
            recursive(node.right, RIGHT, curSum + 1);
            recursive(node.left, LEFT, 0);
            return;
        }

        recursive(node.left, LEFT, curSum + 1);
        recursive(node.right, RIGHT, 0);
    }

}