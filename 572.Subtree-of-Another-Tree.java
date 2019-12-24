// https://leetcode.com/problems/subtree-of-another-tree/
//
// algorithms
// Easy (43.34%)
// Total Accepted: 155,519
// Total Submissions: 358,811


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    static boolean res = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        res = false;
        String tStr = formatT(t);
        recursive(s, tStr);

        return res;
    }

    private String recursive(TreeNode s, String tStr) {
        if (s == null || res) {
            if (tStr.equals("")) {
                res = true;
            }

            return "";
        }

        String l = recursive(s.left, tStr);
        String r = recursive(s.right, tStr);
        StringBuilder sb = new StringBuilder();
        sb.append(l).append(",").append(r).append(",").append(s.val);

        String tmp = sb.toString();
        if (tmp.equals(tStr)) {
            res = true;
        }

        return tmp;
    }

    private String formatT(TreeNode t) {
        if (t == null) {
            return "";
        }

        String l = formatT(t.left);
        String r = formatT(t.right);
        StringBuilder sb = new StringBuilder();
        sb.append(l).append(",").append(r).append(",").append(t.val);

        return sb.toString();
    }
}