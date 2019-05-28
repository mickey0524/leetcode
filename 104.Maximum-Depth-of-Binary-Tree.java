// https://leetcode.com/problems/maximum-depth-of-binary-tree/
//
// algorithms
// Easy (60.50%)
// Total Accepted: 507,058
// Total Submissions: 838,100
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public static int depth;

    public int maxDepth(TreeNode root) {
        Solution.depth = Integer.MIN_VALUE;

        recursive(root, 0);

        return Solution.depth;
    }

    public void recursive(TreeNode root, int curDepth) {
        if (root == null) {
            Solution.depth = Math.max(Solution.depth, curDepth);
            return;
        }

        recursive(root.left, curDepth + 1);
        recursive(root.right, curDepth + 1);
    }
}