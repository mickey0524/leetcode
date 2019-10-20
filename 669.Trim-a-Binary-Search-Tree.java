// https://leetcode.com/problems/trim-a-binary-search-tree/
//
// algorithms
// Easy (61.1%)
// Total Accepted: 77,571
// Total Submissions: 126,949
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        while (root != null && (root.val < L || root.val > R)) {
            if (root.val < L) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        if (root == null) {
            return null;
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
    
}