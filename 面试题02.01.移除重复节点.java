// https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
// algorithms
// Easy (66.42%)
// Total Accepted: 2,581
// Total Submissions: 3,886


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode tmp = new ListNode(-1);
        ListNode pre = tmp;
        tmp.next = head;

        while (head != null) {
            if (set.contains(head.val)) {
                pre.next = head.next;
            } else {
                set.add(head.val);
                pre = head;
            }

            head = head.next;
        }

        return tmp.next;
    }
}