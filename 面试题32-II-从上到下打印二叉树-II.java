// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
// algorithms
// Easy (68.75%)
// Total Accepted: 14,961
// Total Submissions: 21,762


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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        l.add(null);
        ArrayList<Integer> level = new ArrayList<>();
        
        while (true) {
            TreeNode tmp = l.pollFirst();
            if (tmp == null) {
                res.add(level);
                level = new ArrayList<>();
                if (l.isEmpty()) {
                    break;
                } else {
                    l.offer(null);
                }
            } else {
                level.add(tmp.val);
                
                if (tmp.left != null) {
                    l.offer(tmp.left);
                }
                if (tmp.right != null) {
                    l.offer(tmp.right);
                }
            }
        }
        
        return res;
    }
}