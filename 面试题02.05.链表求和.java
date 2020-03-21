// https://leetcode-cn.com/problems/sum-lists-lcci/
// algorithms
// Medium (47.07%)
// Total Accepted: 1,913
// Total Submissions: 4,064


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null || l2 != null) {
            int num = carry;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            if (num >= 10) {
                carry = 1;
                num -= 10;
            } else {
                carry = 0;
            }
            
            ListNode node = new ListNode(num);
            tmp.next = node;
            tmp = node;
        }
        
        if (carry == 1) {
            tmp.next = new ListNode(1);
        }
        
        return res.next;
    }
}