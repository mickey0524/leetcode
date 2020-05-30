// https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
// algorithms
// Medium (55.79%)
// Total Accepted: 16,524
// Total Submissions: 29,616


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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        recursive(root, sum, 0, path, res);
        
        return res;
    }
    
    private void recursive(TreeNode node, int target, int curSum, List<Integer> path, List<List<Integer>> res) {
        if (node.left == null && node.right == null) {
            if (curSum + node.val == target) {
                List<Integer> tmp = new ArrayList<>(path);
                tmp.add(node.val);
                res.add(tmp);
            }
            return;
        }
                
        if (node.left != null) {
            path.add(node.val);
            recursive(node.left, target, curSum + node.val, path, res);
            path.remove(path.size() - 1);
        }
        
        if (node.right != null) {
            path.add(node.val);
            recursive(node.right, target, curSum + node.val, path, res);
            path.remove(path.size() - 1);
        }
    }
}