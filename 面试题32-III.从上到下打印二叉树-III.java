// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
// algorithms
// Easy (59.41%)
// Total Accepted: 12,609
// Total Submissions: 21,224


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        
        boolean leftToRight = true;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        
        while (true) {
            TreeNode node = q.pollFirst();
            if (node == null) {
                res.add(level);
                if (q.isEmpty()) {
                    break;
                }
                
                leftToRight = !leftToRight;
                level = new LinkedList<>();
                q.add(null);
            } else {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                
                if (leftToRight) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
            }
        }
        
        return res;
    }
}