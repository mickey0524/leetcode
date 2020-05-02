// https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
// algorithms
// Easy (57.1%)
// Total Accepted: 13,651
// Total Submissions: 23,903


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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return recursive(root.left, root.right);
    }
    
    private boolean recursive(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        
        if (n1 == null || n2 == null) {
            return false;
        }
        
        if (n1.val == n2.val) {
            return recursive(n1.left, n2.right) && recursive(n1.right, n2.left);
        }
        
        return false;
    }
}