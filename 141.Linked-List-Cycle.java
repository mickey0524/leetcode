// https://leetcode.com/problems/linked-list-cycle/
//
// algorithms
// Easy (36.49%)
// Total Accepted:    389,245
// Total Submissions: 1,066,572

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode first = head.next, second = head.next.next;
        while (second != null) {
            if (first == second) {
                return true;
            }
            first = first.next;
            second = second.next;
            if (second == null) {
                return false;
            }
            second = second.next;
        }
        
        return false;
    }
}