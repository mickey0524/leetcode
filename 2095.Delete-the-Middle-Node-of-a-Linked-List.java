// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
// algorithms
// Medium (61.64%)
// Total Accepted: 9.8K
// Total Submissions: 15.9K


class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode fast = res;
        ListNode slow = res;
        ListNode pre = null;
        res.next = head;
        
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        
        pre.next = slow.next;
        slow.next = null;
        
        return res.next;
    }
}