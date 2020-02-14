// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
// algorithms
// Medium (35.33%)
// Total Accepted: 6,489
// Total Submissions: 18,366
// beats 100.0% of java submissions


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private static final long DIVISOR = 1000000007;
    private static int minDiff = Integer.MAX_VALUE;

    public int maxProduct(TreeNode root) {
        minDiff = Integer.MAX_VALUE;

        int treeValSum = getTreeValSum(root);
        int target = treeValSum >>> 1;
        recursive(root, target);

        long a = (long) (minDiff + target);
        long b = (long) (treeValSum - a);

        return (int) ((a * b) % DIVISOR);
    }

    public int getTreeValSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getTreeValSum(root.left) + getTreeValSum(root.right) + root.val;
    }

    public int recursive(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }

        int sum = recursive(root.left, target) + recursive(root.right, target) + root.val;
        int diff = sum - target;
        if (Math.abs(diff) < Math.abs(minDiff)) {
            minDiff = diff;
        }

        return sum;
    }

}