// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
// algorithms
// Medium (71.58%)
// Total Accepted: 4,148
// Total Submissions: 5,795
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class FindElements {

    TreeNode root;
    HashSet<Integer> s;

    public FindElements(TreeNode root) {
        this.root = root;
        if (root == null) {
            return;
        }

        this.s = new HashSet<>();
        recursive(this.root, 0);
    }

    public void recursive(TreeNode node, int val) {
        if (node == null) {
            return;
        }

        node.val = val;
        this.s.add(val);
        recursive(node.left, val * 2 + 1);
        recursive(node.right, val * 2 + 2);
    }

    public boolean find(int target) {
        return this.s.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root); boolean param_1 =
 * obj.find(target);
 */