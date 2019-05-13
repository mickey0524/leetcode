// https://leetcode.com/problems/reverse-nodes-in-k-group/
//
// algorithms
// Hard (36.23%)
// Total Accepted:    181,141
// Total Submissions: 499,895


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode resTmp = res;
        LinkedList<ListNode> q = new LinkedList<>();
        int curK = 0;
        
        while (head != null) {
            q.offer(head);
            head = head.next;
            curK++;
            if (curK == k) {
                for (int i = 0; i < k; i++) {
                    ListNode tmp = q.pollLast();
                    tmp.next = null;
                    resTmp.next = tmp;
                    resTmp = tmp;
                }
                resTmp.next = head;
                curK = 0;
            }
        }
        
        return res.next;
    }
}