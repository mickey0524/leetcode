// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
// algorithms
// Medium (83.68%)
// Total Accepted: 10,844
// Total Submissions: 12,959
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static final int PLACEHOLDER = 1;
    private static int res;

    public int sumEvenGrandparent(TreeNode root) {
        res = 0;

        recursive(root, PLACEHOLDER, PLACEHOLDER);

        return res;
    }

    private void recursive(TreeNode root, int grandParent, int parent) {
        if (root == null) {
            return;
        }

        if ((grandParent & 1) == 0) {
            res += root.val;
        }

        recursive(root.left, parent, root.val);
        recursive(root.right, parent, root.val);
    }
}