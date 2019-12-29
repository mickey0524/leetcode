// https://leetcode.com/problems/average-of-levels-in-binary-tree/
//
// algorithms
// Easy (32.8%)
// Total Accepted: 40,687
// Total Submissions: 124,024


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, Long> valueMap = new HashMap<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();

        recursive(valueMap, numMap, 0, root);

        ArrayList<Double> l = new ArrayList<>(valueMap.size());
        for (int i = 0; i < valueMap.size(); i++) {
            l.add((double) valueMap.get(i) / numMap.get(i));
        }

        return l;
    }

    public void recursive(HashMap<Integer, Long> valueMap, HashMap<Integer, Integer> numMap, int level, TreeNode node) {
        if (node == null) {
            return;
        }

        valueMap.put(level, valueMap.getOrDefault(level, 0L) + node.val);
        numMap.put(level, numMap.getOrDefault(level, 0) + 1);

        recursive(valueMap, numMap, level + 1, node.left);
        recursive(valueMap, numMap, level + 1, node.right);
    }

}