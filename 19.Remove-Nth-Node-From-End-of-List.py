# https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
#
# algorithms
# Medium (33.7%)
# Total Accepted:    288.4K
# Total Submissions: 856.2K
# beats 99.78% of python submissions


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        first = head
        for _ in xrange(n):
            first = first.next
        parent = ListNode(0)
        pre = parent
        parent.next = head

        while first:
            first = first.next
            pre = head
            head = head.next

        pre.next = head.next

        return parent.next
