// https://leetcode.com/problems/divisor-game/
//
// algorithms
// Medium (52.36%)
// Total Accepted:    2,744
// Total Submissions: 5,241
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
    static int res;
    
    public int maxAncestorDiff(TreeNode root) {
        Solution.res = Integer.MIN_VALUE;
        this.recursive(root);
        
        return Solution.res;
    }
    
    public int[] recursive(TreeNode node) {
        int[] tmp = new int[]{node.val, node.val};
        
        if (node.left != null) {
            int[] leftChild = this.recursive(node.left);
            tmp[0] = Math.min(tmp[0], leftChild[0]);
            tmp[1] = Math.max(tmp[1], leftChild[1]);
            Solution.res = Math.max(Solution.res, Math.max(Math.abs(node.val - leftChild[0]), Math.abs(node.val - leftChild[1])));
        }
        if (node.right != null) {
            int[] rightChild = this.recursive(node.right);
            tmp[0] = Math.min(tmp[0], rightChild[0]);
            tmp[1] = Math.max(tmp[1], rightChild[1]);
            Solution.res = Math.max(Solution.res, Math.max(Math.abs(node.val - rightChild[0]), Math.abs(node.val - rightChild[1])));
        }
        
        return tmp;
    }
}