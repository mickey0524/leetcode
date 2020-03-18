// https://leetcode.com/problems/balance-a-binary-search-tree/
// algorithms
// Easy (74.31%)
// Total Accepted: 5,928
// Total Submissions: 7,977


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> l = new ArrayList<>();
        traversalTree(root, l);

        return buildBalanceBST(l, 0, l.size() - 1);
    }

    private void traversalTree(TreeNode root, ArrayList<TreeNode> l) {
        if (root == null) {
            return;
        }

        traversalTree(root.left, l);
        l.add(root);
        traversalTree(root.right, l);
    }

    private TreeNode buildBalanceBST(ArrayList<TreeNode> l, int left, int right) {
        if (right < left) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = l.get(mid);
        root.left = buildBalanceBST(l, left, mid - 1);
        root.right = buildBalanceBST(l, mid + 1, right);

        return root;
    }

}