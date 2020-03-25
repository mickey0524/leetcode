// https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
// algorithms
// Easy (36.38%)
// Total Accepted: 1,327
// Total Submissions: 3,648

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
    private static TreeNode pre;
    
    public boolean isValidBST(TreeNode root) {
        res = true;
        pre = null;
        
        recursive(root);
        
        return res;
    }
    
    private void recursive(TreeNode node) {
        if (!res || node == null) {
            return;
        }
        
        recursive(node.left);
    
        if (pre != null && node.val <= pre.val) {
            res = false;
            return;
        }
        pre = node;
            
        recursive(node.right);
    }
    
}