// https://leetcode.com/problems/path-sum/
//
// algorithms
// Easy (37.95%)
// Total Accepted: 320,318
// Total Submissions: 844,145x
// beats 100.0% of java submissions

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return recursive(root, 0, sum);
    }
    
    public boolean recursive(TreeNode root, int curSum, int sum) {
        if (root.left == null && root.right == null) {
            if (curSum + root.val == sum) {
                return true;
            }
            return false;
        }
        
        boolean res = false;
        if (root.left != null) {
            res = recursive(root.left, curSum + root.val, sum);
        }
        if (!res && root.right != null) {
            res = recursive(root.right, curSum + root.val, sum);
        }
        return res;
    }
}