// https://leetcode.com/problems/root-equals-sum-of-children/
// algorithms
// Easy (89.80%)
// Total Accepted: 11,986
// Total Submissions: 13,348


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
    
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
    
}