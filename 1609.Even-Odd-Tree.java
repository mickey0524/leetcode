// https://leetcode.com/problems/even-odd-tree/
// algorithms
// Medium (55.83%)
// Total Accepted: 7,911
// Total Submissions: 14,169
// beats 100.0% of java submissions

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);
        int flag = 1;
        int lastValue = -1;

        while (true) {
            TreeNode node = queue.pollFirst();
            if (node == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.offer(null);
                flag = 1 - flag;
                lastValue = -1;
            } else {
                if ((node.val & 1) != flag) {
                    return false;
                }

                if (lastValue != -1) {
                    if (flag == 1 && node.val <= lastValue) {
                        return false;
                    }

                    if (flag == 0 && node.val >= lastValue) {
                        return false;
                    }
                }

                lastValue = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }

        return true;
    }
}