// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// algorithms
// Medium (69.5%)
// Total Accepted: 7,563
// Total Submissions: 10,882
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private static int res = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        res = 0;
        recursive(root, Integer.MIN_VALUE);
        
        return res;
    }
    
    private void recursive(TreeNode node, int curMax) {
        if (node.val >= curMax) {
            res++;
            curMax = node.val;
        }
        
        if (node.left != null) {
            recursive(node.left, curMax);    
        }
        
        if (node.right != null) {
            recursive(node.right, curMax);
        }
    }
    
}