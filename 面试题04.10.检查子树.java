// https://leetcode-cn.com/problems/check-subtree-lcci/
// algorithms
// Medium (72.03%)
// Total Accepted: 1,473
// Total Submissions: 2,045

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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (helper(t1, t2)) {
            return true;
        }
        
        if (t1 == null) {
            return false;
        }
        
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
    
    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null || t2 == null) {
            return false;
        }
        
        if (t1.val == t2.val) {
            return helper(t1.left, t2.left) && helper(t1.right, t2.right);
        }
        
        return false;
    }
}