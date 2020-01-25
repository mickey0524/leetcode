// https://leetcode.com/problems/delete-leaves-with-a-given-value/
// algorithms
// Medium (74.02%)
// Total Accepted: 7,475
// Total Submissions: 10,098
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        TreeNode l = removeLeafNodes(root.left, target);
        TreeNode r = removeLeafNodes(root.right, target);

        if (l == null && r == null && root.val == target) {
            return null;
        }

        root.left = l;
        root.right = r;

        return root;
    }

}