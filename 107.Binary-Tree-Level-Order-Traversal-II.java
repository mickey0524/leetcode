// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//
// algorithms
// Easy (47.04%)
// Total Accepted: 229,826
// Total Submissions: 488,538
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        q.add(root);
        q.add(null);
        
        while (true) {
            TreeNode curItem = q.pollFirst();
            if (curItem == null) {
                res.offerFirst(new ArrayList<Integer>(path));
                if (q.size() == 0) {
                    break;
                }
                path.clear();
                q.add(null);
            } else {
                path.add(curItem.val);
                if (curItem.left != null) {
                    q.add(curItem.left);
                }
                if (curItem.right != null) {
                    q.add(curItem.right);
                }
            }
        }
        
        return res;
    }
}