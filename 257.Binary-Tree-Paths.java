// https://leetcode.com/problems/binary-tree-paths/
//
// algorithms
// Easy (48.77%)
// Total Accepted: 273,861
// Total Submissions: 561,480
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static final String ARROW = "->";

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        recursive(sb, root, res);

        return res;
    }

    public void recursive(StringBuilder sb, TreeNode node, ArrayList<String> res) {
        if (node == null) {
            return;
        }

        if (sb.length() > 0) {
            sb.append(ARROW);
        }
        sb.append(node.val);

        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        } else {
            recursive(sb, node.left, res);
            recursive(sb, node.right, res);
        }

        int idx = sb.lastIndexOf(ARROW);
        if (idx != -1) {
            sb.delete(idx, sb.length());
        }
    }
}