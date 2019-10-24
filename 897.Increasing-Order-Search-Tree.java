// https://leetcode.com/problems/increasing-order-search-tree/
//
// algorithms
// Easy (66.11%)
// Total Accepted:    43,879
// Total Submissions: 66,373


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
    static TreeNode pre, res;
    
    public TreeNode increasingBST(TreeNode root) {
        pre = null;
        res = null;
        
        recursive(root);
        
        return res;
    }
    
    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        
        recursive(node.left);
        if (pre == null) {
            pre = node;
            res = node;
        } else {
            pre.right = node;
            pre = node;
            node.left = null;
        }
        recursive(node.right);
    }
}