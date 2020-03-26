// https://leetcode-cn.com/problems/check-balance-lcci/
// algorithms
// Easy (61.14%)
// Total Accepted: 1,583
// Total Submissions: 2,589


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
    
    private static boolean res;
    
    public boolean isBalanced(TreeNode root) {
        res = true;
        
        recursive(root);
        
        return res;
    }
    
    private int recursive(TreeNode root) {
        if (!res || root == null) {
            return 0;
        }
        
        int leftHeight = recursive(root.left);
        int rightHeight = recursive(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            res = false;
            return 0;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}