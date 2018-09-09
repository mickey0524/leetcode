# https://leetcode.com/problems/swap-nodes-in-pairs/description/
#
# algorithms
# Medium (40.66%)
# Total Accepted:    236.9k
# Total Submissions: 582.7k
# beats 100.0% of python submissions


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head

        res = ListNode(0)
        before = res
        res.next = head
        tail = head.next

        while tail != None:
            head.next = tail.next
            tail.next = head
            before.next = tail
            before = head
            head = head.next
            if head:
                tail = head.next
            else:
                break

        return res.next
