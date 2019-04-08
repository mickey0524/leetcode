// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
//
// algorithms
// Medium (38.23%)
// Total Accepted:    4,152
// Total Submissions: 10,860


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
    static int res;
    
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Solution.res = 0;
        
        this.recursive(root, 0);
        
        return Solution.res;
    }
    
    public void recursive(TreeNode root, int curSum) {
        int tmp = (curSum << 1) + root.val;
        if (root.left == null && root.right == null) {
            Solution.res += tmp;
            return;
        }
        
        if (root.left != null) {
            recursive(root.left, tmp);
        }
        
        if (root.right != null) {
            recursive(root.right, tmp);
        }
    }
}