# https://leetcode.com/problems/merge-two-sorted-lists/
#
# algorithms
# Easy (44.68%)
# Total Accepted:    466,336
# Total Submissions: 1,043,698

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        res = ListNode(-1)
        tmp = res
        
        while l1 and l2:
            if l1.val <= l2.val:
                res.next = l1
                l1 = l1.next
            else:
                res.next = l2
                l2 = l2.next
            res = res.next
        
        if l1 and not l2:
            res.next = l1
        elif l2 and not l1:
            res.next = l2
        
        return tmp.next