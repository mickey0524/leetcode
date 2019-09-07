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


class Solution1(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head

        tmp = head
        while tmp:
            next_node = tmp.next
            while next_node and tmp.val == next_node.val:
                next_node = next_node.next

            tmp.next = next_node
            tmp = next_node

        return head
