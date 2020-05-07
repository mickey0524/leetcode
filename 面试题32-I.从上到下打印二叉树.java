// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
// algorithms
// Medium (63.68%)
// Total Accepted: 13,407
// Total Submissions: 21,053


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
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode tmp = q.pollFirst();
            l.add(tmp.val);
            
            if (tmp.left != null) {
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                q.offer(tmp.right);
            }
        }
        
        int len = l.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = l.get(i);
        }
        
        return res;
    }
}