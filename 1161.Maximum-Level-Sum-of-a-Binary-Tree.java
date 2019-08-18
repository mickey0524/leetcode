// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
//
// algorithms
// Easy (72.24%)
// Total Accepted: 3,412
// Total Submissions: 4,723
// beats 100.0% of java submissions

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        int levelSum = 0, maxSum = Integer.MIN_VALUE;
        int level = 1, res = 1;

        while (true) {
            TreeNode curNode = q.pollFirst();
            if (curNode == null) {
                if (levelSum > maxSum) {
                    maxSum = levelSum;
                    res = level;
                }
                if (q.size() == 0) {
                    break;
                }
                q.offer(null);
                levelSum = 0;
                level++;
            } else {
                levelSum += curNode.val;
                if (curNode.left != null) {
                    q.offer(curNode.left);
                }

                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
            }
        }

        return res;
    }
}