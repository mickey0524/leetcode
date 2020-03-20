// https://leetcode-cn.com/problems/partition-list-lcci/
// algorithms
// Medium (64.6%)
// Total Accepted: 1,462
// Total Submissions: 2,263


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerThanX = new ListNode(-1);
        ListNode smallerThanXTmp = smallerThanX;
        ListNode biggerThanX = new ListNode(-1);
        ListNode biggerThanXTmp = biggerThanX;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = null;
            if (head.val >= x) {
                biggerThanXTmp.next = head;
                biggerThanXTmp = head;
            } else {
                smallerThanXTmp.next = head;
                smallerThanXTmp = head;
            }

            head = tmp;
        }

        if (smallerThanX.next == null) {
            return biggerThanX.next;
        }

        smallerThanXTmp.next = biggerThanX.next;

        return smallerThanX.next;
    }
}