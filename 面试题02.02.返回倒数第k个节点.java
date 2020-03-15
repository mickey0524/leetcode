// https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
// algorithms
// Easy (79.56%)
// Total Accepted: 3,394
// Total Submissions: 4,266


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }

        return head.val;
    }
}