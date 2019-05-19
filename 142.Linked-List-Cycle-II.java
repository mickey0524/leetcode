// https://leetcode.com/problems/linked-list-cycle-ii/
//
// algorithms
// Medium (31.93%)
// Total Accepted:    212,281
// Total Submissions: 664,890
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode st = head, nd = head.next;

        while (nd != null && st != nd) {
            st = st.next;
            nd = nd.next;
            if (nd != null) {
                nd = nd.next;
            }
        }

        if (nd == null) {
            return null;
        }

        int cycleLen = 1;
        st = nd.next;
        while (st != nd) {
            cycleLen++;
            st = st.next;
        }

        st = head;
        nd = head;
        for (int i = 0; i < cycleLen; i++) {
            st = st.next;
        }

        while (st != nd) {
            st = st.next;
            nd = nd.next;
        }

        return st;
    }
}