// https://leetcode-cn.com/problems/minimum-height-tree-lcci/
// algorithms
// Easy (79.91%)
// Total Accepted: 2,808
// Total Submissions: 3,514


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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        
        return helper(nums, 0, len - 1);
    }
    
    private TreeNode helper(int[] nums, int i, int j) {
        if (j < i) {
            return null;
        }
        
        if (j == i) {
            return new TreeNode(nums[i]);
        }
        
        int m = i + (j - i) / 2;
        TreeNode tmp = new TreeNode(nums[m]);
        tmp.left = helper(nums, i, m - 1);
        tmp.right = helper(nums, m + 1, j);
        
        return tmp;
    }
}