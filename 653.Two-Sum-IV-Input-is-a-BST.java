// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//
// algorithms
// Easy (53.45%)
// Total Accepted: 104,346
// Total Submissions: 195,220
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    static boolean res;

    public boolean findTarget(TreeNode root, int k) {
        res = false;
        HashMap<Integer, Boolean> map = new HashMap<>();

        recursive(root, k, map);

        return res;
    }

    public void recursive(TreeNode node, int k, HashMap<Integer, Boolean> map) {
        if (res || node == null) {
            return;
        }

        recursive(node.left, k, map);
        if (k - node.val < node.val && map.containsKey(k - node.val)) {
            res = true;
            return;
        }
        map.put(node.val, true);
        recursive(node.right, k, map);
    }
}