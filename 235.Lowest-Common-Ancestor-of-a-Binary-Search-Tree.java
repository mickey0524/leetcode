// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//
// algorithms
// Easy (44.32%)
// Total Accepted:    274,537
// Total Submissions: 619,477
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
            
        }
		return null; 
    }
}