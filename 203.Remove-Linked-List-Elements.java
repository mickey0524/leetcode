// https://leetcode.com/problems/remove-linked-list-elements/
//
// algorithms
// Easy (35.57%)
// Total Accepted:    217,102
// Total Submissions: 610,273
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            }
            return head;
        }
        
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        pre.next = head;
        
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = pre.next;     
            } else {
                pre = head;
                head = head.next;
            }
        }
        
        return res.next;
    }
}