// https://leetcode.com/problems/rotate-list/
//
// algorithms
// Medium (27.10%)
// Total Accepted:    191,463
// Total Submissions: 706,379


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode tmp = head, tail = null;
        int len = 0;
        while (tmp != null) {
            len++;
            tail = tmp;
            tmp = tmp.next;
        }
        
        k %= len;
        k = len - k;
        for (int i = 0; i < k; i++) {
            tmp = head.next;
            head.next = null;
            tail.next = head;
            tail = head;
            head = tmp;
        }
        
        return head;
    }
}