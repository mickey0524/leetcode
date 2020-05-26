// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
// algorithms
// Medium (66.12%)
// Total Accepted: 9,301
// Total Submissions: 14,067
// beats 100.0% of java submissions


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
    
    private static int[] flag = new int[10];
    private static int res = 0;
    
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Arrays.fill(flag, 0);
        res = 0;
        recursive(root);
        
        return res;
    }
    
    private void recursive(TreeNode node) {
        flag[node.val]++;
        if (node.left == null && node.right == null) {
            if (isPalindrome()) {
                res++;
            }
            flag[node.val]--;
            
            return;
        }
        
        if (node.left != null) {
            recursive(node.left);
        }
        if (node.right != null) {
            recursive(node.right);
        }
        flag[node.val]--;
    }
    
    private boolean isPalindrome() {
        boolean oddExist = false;
        
        for (int i = 1; i < 10; i++) {
            if ((flag[i] & 1) == 1) {
                if (oddExist) {
                    return false;
                }
                oddExist = true;
            }
        }
        
        return true;
    }
}