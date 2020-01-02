// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
// algorithms
// Easy (76.89%)
// Total Accepted: 6,458
// Total Submissions: 8,399
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();

        while (root1 != null || root2 != null) {
            if (root1 != null) {
                stack1.addFirst(root1);
                root1 = root1.left;
            }
            if (root2 != null) {
                stack2.addFirst(root2);
                root2 = root2.left;
            }
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode tmp1 = stack1.peekFirst();
            TreeNode tmp2 = stack2.peekFirst();
            LinkedList<TreeNode> tmpStack = null;

            if (tmp1 == null) {
                tmpStack = stack2;
            } else if (tmp2 == null) {
                tmpStack = stack1;
            } else {
                tmpStack = tmp1.val >= tmp2.val ? stack2 : stack1;
            }

            TreeNode tmp = tmpStack.pollFirst();
            res.add(tmp.val);
            if (tmp.right != null) {
                tmp = tmp.right;
                while (tmp != null) {
                    tmpStack.addFirst(tmp);
                    tmp = tmp.left;
                }
            }
        }

        return res;
    }

}