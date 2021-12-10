// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
// algorithms
// Medium (42.31%)
// Total Accepted: 6.6K
// Total Submissions: 15.6K

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private static List<Character> path;
    private static boolean found;
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        found = false;
        recursive(root, startValue, new ArrayList<>());
        List<Character> startNodeList = new ArrayList<>(path);
        
        found = false;
        recursive(root, destValue, new ArrayList<>());
        List<Character> destNodeList = new ArrayList<>(path);
        
        int len = Math.min(startNodeList.size(), destNodeList.size());
        int idx = 0;
        for (; idx < len; idx++) {
            if (startNodeList.get(idx) != destNodeList.get(idx)) {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < startNodeList.size(); i++) {
            sb.append('U');
        }
        
        for (int i = idx; i < destNodeList.size(); i++) {
            sb.append(destNodeList.get(i));
        }
        
        return sb.toString();
    }
    
    private void recursive(TreeNode root, int target, List<Character> tmp) {
        if (found) {
            return;
        }
        
        if (root.val == target) {
            found = true;
            path = new ArrayList<>(tmp);
            return;
        }
        
        if (root.left != null) {
            tmp.add('L');
            recursive(root.left, target, tmp);
            tmp.remove(tmp.size() - 1);  
        }

        if (root.right != null) {        
            tmp.add('R');
            recursive(root.right, target, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    
}