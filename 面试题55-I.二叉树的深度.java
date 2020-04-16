// https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
// algorithms
// Easy (78.89%)
// Total Accepted: 14,846
// Total Submissions: 18,819


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private static int maxDepth;
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxDepth = 1;
        recursive(root, 0);
        
        return maxDepth;
    }
    
    private void recursive(TreeNode node, int curDepth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, curDepth);
            return;
        }
        
        recursive(node.left, curDepth + 1);
        recursive(node.right, curDepth + 1);
    }
}