# https://leetcode.com/problems/remove-duplicates-from-sorted-list/
#
# algorithms
# Easy (42.7%)
# Total Accepted:    332,652
# Total Submissions: 779,084


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        res = head
        tmp = res

        while head:
            while head.next and head.next.val == head.val:
                head = head.next

            if tmp.val != head.val:
                tmp.next = head
                tmp = tmp.next

            head = head.next

        if tmp:
            tmp.next = None

        return res
