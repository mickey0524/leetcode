/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<QueueItem> q = new LinkedList<>();
        q.offer(new QueueItem(0, root));
        q.offer(null);
        int res = Integer.MIN_VALUE;
        int l = -1, r = -1;

        while (true) {
            QueueItem item = q.pollFirst();
            if (item == null) {
                res = Math.max(res, r - l + 1);
                l = -1;
                r = -1;
                if (q.size() == 0) {
                    break;
                }
                q.offer(null);
            } else {
                if (l == -1) {
                    l = item.idx;
                }
                r = item.idx;
                if (item.node.left != null) {
                    q.offer(new QueueItem(item.idx * 2 + 1, item.node.left));
                }
                if (item.node.right != null) {
                    q.offer(new QueueItem(item.idx * 2 + 2, item.node.right));
                }
            }
        }

        return res;
    }

    class QueueItem {
        private int idx;
        private TreeNode node;

        QueueItem(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }
}