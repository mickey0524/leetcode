// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
// algorithms
// Hard (38.66%)
// Total Accepted: 31,200
// Total Submissions: 80,709

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
    
    private int res = 0;
    
    public int maxSumBST(TreeNode root) {
        helper(root);
        
        return res;
    }
    
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        
        // idx_0 是否为 BST，idx_1 最大值，idx_2 最小值，idx_3 val 和
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        if (left[0] == 1 && right[0] == 1 && left[1] < node.val && right[2] > node.val) {
            res = Math.max(res, left[3] + right[3] + node.val);
            return new int[]{1, Math.max(node.val, right[1]), Math.min(node.val, left[2]), left[3] + right[3] + node.val};
        } else {
            return new int[]{0, -1, -1, -1};
        }
    }
    
}