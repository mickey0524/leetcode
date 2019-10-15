// https://leetcode.com/problems/construct-string-from-binary-tree/
//
// algorithms
// Easy (52.33%)
// Total Accepted: 66,646
// Total Submissions: 127,357
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    static StringBuilder sb;
    static final char LEFT_BRACKET = '(';
    static final char RIGHT_BRACKET = ')';

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        sb = new StringBuilder();
        recursive(t);

        return sb.toString();
    }

    public void recursive(TreeNode node) {
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left == null) {
            sb.append(LEFT_BRACKET).append(RIGHT_BRACKET);
        } else {
            sb.append(LEFT_BRACKET);
            recursive(node.left);
            sb.append(RIGHT_BRACKET);
        }
        if (node.right != null) {
            sb.append(LEFT_BRACKET);
            recursive(node.right);
            sb.append(RIGHT_BRACKET);
        }
    }
}