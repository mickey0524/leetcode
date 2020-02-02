// https://leetcode.com/problems/middle-of-the-linked-list/
//
// algorithms
// Easy (66.62%)
// Total Accepted: 105,963
// Total Submissions: 160,558
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = slow;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            slow = slow.next;
        }

        return slow;
    }
}