// https://leetcode.com/problems/convert-bst-to-greater-tree/
//
// algorithms
// Easy (50.39%)
// Total Accepted:    73,388
// Total Submissions: 145,653
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
    
    static int curSum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        Solution.curSum = 0;
        recursive(root);
        
        return root;
    }
    
    public void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        
        this.recursive(root.right);
        root.val = root.val + Solution.curSum;
        Solution.curSum = root.val;
        this.recursive(root.left);
    }
}