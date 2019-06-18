// https://leetcode.com/problems/unique-binary-search-trees-ii/
//
// algorithms
// Medium (35.90%)
// Total Accepted: 140,547
// Total Submissions: 391,485
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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return recursive(1, n);
    }

    public List<TreeNode> recursive(int head, int tail) {
        if (head > tail) {
            ArrayList<TreeNode> l = new ArrayList<>();
            l.add(null);
            return l;
        }
        if (head == tail) {
            ArrayList<TreeNode> l = new ArrayList<>();
            l.add(new TreeNode(head));
            return l;
        }

        ArrayList<TreeNode> l = new ArrayList<>();
        for (int i = head; i <= tail; i++) {
            List<TreeNode> leftList = recursive(head, i - 1);
            List<TreeNode> rightList = recursive(i + 1, tail);

            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftList.get(j);
                    node.right = rightList.get(k);
                    l.add(node);
                }
            }
        }
        
        return l;
    }
}