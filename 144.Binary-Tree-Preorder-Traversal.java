// https://leetcode.com/problems/binary-tree-preorder-traversal/
//
// algorithms
// Medium (51.62%)
// Total Accepted: 346,095
// Total Submissions: 670,470

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        recursive(root, res);

        return res;
    }

    public void recursive(TreeNode root, ArrayList<Integer> l) {
        if (root == null) {
            return;
        }

        l.add(root.val);
        recursive(root.left, l);
        recursive(root.right, l);
    }
}

class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() != 0) {
            if (root == null) {
                root = stack.pollLast();
            }
            while (root != null) {
                res.add(root.val);
                if (root.right != null) {
                    stack.offerLast(root.right);
                }
                root = root.left;
            }
        }

        return res;
    }
}
