// https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
// algorithms
// Medium (68.07%)
// Total Accepted: 31,248
// Total Submissions: 45,907


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int len = preorder.length;

        return buildTreeInner(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildTreeInner(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd < preStart) {
            return null;
        }

        if (preEnd == preStart) {
            return new TreeNode(preorder[preStart]);
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                idx = i;
                break;
            }
        }

        node.left = buildTreeInner(preorder, inorder, preStart + 1, preStart + idx - inStart, inStart, idx - 1);
        node.right = buildTreeInner(preorder, inorder, preStart + idx - inStart + 1, preEnd, idx + 1, inEnd);

        return node;
    }
}