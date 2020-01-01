// https://leetcode.com/problems/deepest-leaves-sum/
// algorithms
// Medium (86.67%)
// Total Accepted: 4,080
// Total Submissions: 4,708


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static int res = 0;

    public int deepestLeavesSum(TreeNode root) {
        res = 0;
        int height = getHeight(root) - 1;

        recursive(root, height, 0);

        return res;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public void recursive(TreeNode root, int targetHeight, int curHeight) {
        if (root == null) {
            return;
        }

        if (curHeight == targetHeight) {
            res += root.val;
            return;
        }

        recursive(root.left, targetHeight, curHeight + 1);
        recursive(root.right, targetHeight, curHeight + 1);
    }
}