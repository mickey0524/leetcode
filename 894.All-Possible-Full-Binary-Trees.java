// https://leetcode.com/problems/all-possible-full-binary-trees/
//
// algorithms
// Medium (71.71%)
// Total Accepted:    22,376
// Total Submissions: 31,205
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
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            res.add(root);
        }

        for (int i = 1; i <= N / 2; i += 2) {
            List<TreeNode> leftArr = allPossibleFBT(i);
            List<TreeNode> rightArr = allPossibleFBT(N - 1 - i);
            boolean isSym = N - 1 - i != i;
                
            for (TreeNode l : leftArr) {
                for (TreeNode r : rightArr) {
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                    if (isSym) {
                        TreeNode node1 = new TreeNode(0);
                        node1.left = r;
                        node1.right = l;
                        res.add(node1);
                    }
                }
            }
        }
        
        return res;
    }
}