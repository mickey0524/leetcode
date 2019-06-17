// https://leetcode.com/problems/reverse-linked-list-ii/
//
// algorithms
// Medium (35.09%)
// Total Accepted: 197,164
// Total Submissions: 561,905
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) {
            return head;
        }

        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode tmp = res;

        for (int i = 0; i < m - 1; i++) {
            tmp = tmp.next;
        }

        head = tmp.next.next;
        ListNode last = tmp.next;
        for (int i = 0; i < n - m; i++) {
            ListNode nodeTmp = head.next;

            head.next = tmp.next;
            tmp.next = head;
            head = nodeTmp;
            last.next = nodeTmp;
        }

        return res.next;
    }
}