// https://leetcode-cn.com/problems/successor-lcci/
// algorithms
// Easy (56.57%)
// Total Accepted: 1,248
// Total Submissions: 2,206


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
    
    private static TreeNode res;
    private static TreeNode pre;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        res = null;
        pre = null;
        
        recursive(root, p);
        
        return res;
    }
    
    private void recursive(TreeNode node, TreeNode p) {
        if (res != null || node == null) {
            return;
        }

        recursive(node.left, p);
        
        if (res == null && pre == p) {
            res = node;
            return;
        }
        pre = node;
        
        recursive(node.right, p);
    }
    
}