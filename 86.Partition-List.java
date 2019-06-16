// https://leetcode.com/problems/partition-list/
//
// algorithms
// Medium (37.42%)
// Total Accepted: 165,729
// Total Submissions: 442,946
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
    public ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode(-1), small = new ListNode(-1);
        ListNode bitTmp = big, smallTmp = small;
        
        while (head != null) {
            ListNode tmp = head.next;
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head.next = null;
            head = tmp;
        }
        
        small.next = bitTmp.next;
        
        return smallTmp.next;
    }
}