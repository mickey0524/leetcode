// https://leetcode.com/problems/linked-list-cycle/
//
// algorithms
// Hard (48.21%)
// Total Accepted:    255,908
// Total Submissions: 530,856

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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        LinkedList<TreeNode> s = new LinkedList<>();
        
        TreeNode tmp = root, pre = null;
        
        while (s.size() != 0 || tmp != null) {
            while (tmp != null) {
                s.offer(tmp);
                tmp = tmp.left;
            }
            tmp = s.peekLast();
            if (tmp.right == null || pre == tmp.right) {
                tmp = s.pollLast();
                l.add(tmp.val);
                pre = tmp;
                tmp = null;
            } else {
                tmp = tmp.right;
            }
        }
        
        return l;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        
        recursive(l, root);
        
        return l;
    }
    
    public void recursive(ArrayList<Integer> l, TreeNode root) {
        if (root == null) {
            return;
        }
        
        recursive(l, root.left);
        recursive(l, root.right);
        l.add(root.val);
    }
}