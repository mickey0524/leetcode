// https://leetcode.com/problems/linked-list-in-binary-tree/
// algorithms
// Medium (38.32%)
// Total Accepted: 5,448
// Total Submissions: 14,217
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (recursive(head, root)) {
            return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean recursive(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }

        return recursive(head.next, root.left) || recursive(head.next, root.right);
    }
}