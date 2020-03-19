// https://leetcode-cn.com/problems/delete-middle-node-lcci/
// algorithms
// Easy (76.32%)
// Total Accepted: 3,504
// Total Submissions: 4,591


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}