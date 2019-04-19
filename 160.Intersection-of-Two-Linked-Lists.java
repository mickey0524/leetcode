// https://leetcode.com/problems/intersection-of-two-linked-lists/
//
// algorithms
// Easy (33.21%)
// Total Accepted:    291,291
// Total Submissions: 877,232
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ALen = 0, BLen = 0;
        ListNode tmp = headA;
        
        while (tmp != null) {
            ALen++;
            tmp = tmp.next;
        }
        
        tmp = headB;
        
        while (tmp != null) {
            BLen++;
            tmp = tmp.next;
        }
        
        ListNode fast = (ALen >= BLen) ? headA : headB;
        ListNode slow = (ALen >= BLen) ? headB : headA;
        for (int i = 0; i < Math.abs(ALen - BLen); i++) {
            fast = fast.next;
        }
        
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        
        return null;
    }
}