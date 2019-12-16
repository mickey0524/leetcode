// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
// algorithms
// Easy (86.58%)
// Total Accepted: 5,557
// Total Submissions: 6,418
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }

        return res;
    }
}