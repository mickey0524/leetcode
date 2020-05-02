// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
// algorithms
// Easy (75.35%)
// Total Accepted: 26,313
// Total Submissions: 34,921


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
        ListNode res = new ListNode(-1);
        
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res.next;
            res.next = head;
            
            head = tmp;
        }
        
        return res.next;
    }
}