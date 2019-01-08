# https://leetcode.com/problems/rotate-list/
#
# algorithms
# Medium (26.09%)
# Total Accepted:    169,600
# Total Submissions: 650,019

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        length = 0
        tmp = head
        tail = None
        while tmp:
            length += 1
            tail = tmp
            tmp = tmp.next
        
        if length == 0:
            return head
        
        k %= length
        if k == 0:
            return head
        
        tmp = head
        pre = None
        for _ in xrange(length - k):
            pre = tmp
            tmp = tmp.next
        
        res = ListNode(-1)
        res.next = tmp
        pre.next = None
        tail.next = head
        
        return res.next
        