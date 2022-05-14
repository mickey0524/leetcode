// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// algorithms
// Medium (84.84%)
// Total Accepted: 12,063
// Total Submissions: 14,219


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
    
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        recursive(root);
        
        return res;
    }
    
    private int[] recursive(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = recursive(root.left);
        int[] right = recursive(root.right);
        int valSum = left[1] + right[1] + root.val;
        int nodeNum = left[0] + right[0] + 1;
        int averageVal = valSum / nodeNum;
        if (root.val == averageVal) {
            res++;
        }
        
        return new int[]{nodeNum, valSum};
    }
    
}