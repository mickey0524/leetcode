// https://leetcode.com/problems/remove-linked-list-elements/
//
// algorithms
// Easy (35.57%)
// Total Accepted:    217,102
// Total Submissions: 610,273
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode pre = tmp;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }

            head = head.next;
        }

        return tmp.next;
    }
}