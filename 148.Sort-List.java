// https://leetcode.com/problems/sort-list/
//
// algorithms
// Medium (34.81%)
// Total Accepted:    179,359
// Total Submissions: 515,226


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode l = head, r = head.next, pre = null;
        
        while (r != null) {
            pre = l;
            l = l.next;
            r = r.next;
            if (r != null) {
                r = r.next;
            }
        }
        
        pre.next = null;
        
        r = this.sortList(l);
        l = this.sortList(head);
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        
        while (l != null && r != null) {
            if (l.val <= r.val) {
                res.next = l;
                l = l.next;
            } else {
                res.next = r;
                r = r.next;
            }
            res = res.next;
            res.next = null;
        }
        
        if (l != null) {
            res.next = l;
        }
        if (r != null) {
            res.next = r;
        }
        
        return tmp.next;
    }
}