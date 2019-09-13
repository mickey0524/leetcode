// https://leetcode.com/problems/most-frequent-subtree-sum/
//
// algorithms
// Medium (55.4%)
// Total Accepted:    54,193
// Total Submissions: 97,823
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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        recursive(root, map);
        
        ArrayList<Integer> l = new ArrayList<>();
        int curMax = Integer.MIN_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if (v > curMax) {
                curMax = v;
                l = new ArrayList<>();
                l.add(k);
            } else if (v == curMax) {
                l.add(k);
            }
        }
        
        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        
        return res;
    }
    
    public int recursive(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        
        int l = recursive(node.left, map);
        int r = recursive(node.right, map);
        int tmp = l + r + node.val;
        
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        
        return tmp;
    }
}