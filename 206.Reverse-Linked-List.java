// https://leetcode.com/problems/reverse-linked-list/
//
// algorithms
// Easy (53.87%)
// Total Accepted:    557,002
// Total Submissions: 1,034,002
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode res = new ListNode(0);
        ListNode tmp = null;
        
        while (head != null) {
            tmp = head.next;
            head.next = res.next;
            res.next = head;
            head = tmp;
        }
        
        return res.next;
    }
}