// https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
// algorithms
// Easy (49.97%)
// Total Accepted: 2,241
// Total Submissions: 4,485


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead, fast = newHead, pre = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        
        ListNode right = slow.next;
        slow.next = pre;
        ListNode left = fast == null ? pre : slow;
    
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            
            right = right.next;
            left = left.next;
        }
        
        return true;
    }
}