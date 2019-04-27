// https://leetcode.com/problems/delete-node-in-a-linked-list/
//
// algorithms
// Easy (53.01%)
// Total Accepted:    278,515
// Total Submissions: 525,381
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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
