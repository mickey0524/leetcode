# https: // leetcode.com/problems/middle-of-the-linked-list/description/
#
# algorithms
# Easy (69.1%)
# Total Accepted:    6.1k
# Total Submissions: 8.8k
# beats 9.07% of python submissions

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head.next:
          return head

        tail = head.next
        while tail:
          head = head.next
          if not tail.next or not tail.next.next:
            break
          tail = tail.next.next

        return head
