// https://leetcode-cn.com/problems/paths-with-sum-lcci/
// algorithms
// Medium (52.09%)
// Total Accepted: 1,149
// Total Submissions: 2,206


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
    
    private static int res;
    
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        
        recursive(root, sum);
        
        return res;
    }
    
    private List<Integer> recursive(TreeNode node, int sum) {
        if (node == null) {
            return Collections.emptyList();
        }
        
        List<Integer> leftChild = recursive(node.left, sum);
        List<Integer> rightChild = recursive(node.right, sum);
        List<Integer> l = new ArrayList<>(leftChild.size() + rightChild.size() + 1);
        int tmp = -1;
        
        for (int n : leftChild) {
            tmp = n + node.val;
            if (tmp == sum) {
                res++;
            }
            l.add(tmp);
        }
        
        for (int n : rightChild) {
            tmp = n + node.val;
            if (tmp == sum) {
                res++;
            }
            l.add(tmp);
        }
        
        if (node.val == sum) {
            res++;
        }
        l.add(node.val);
        
        return l;
    }
}