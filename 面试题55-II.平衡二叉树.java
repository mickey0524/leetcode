// https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
// algorithms
// Easy (58.25%)
// Total Accepted: 9,761
// Total Submissions: 16,822


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
    
    private int recursive(TreeNode node) {
        if (!res || node == null) {
            return 0;
        }
        
        int left = recursive(node.left), right = recursive(node.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        
        return Math.max(left, right) + 1;
    }
}