# https://leetcode.com/problems/add-two-numbers/
#
# algorithms
# Medium (31.07%)
# Total Accepted:    864,234
# Total Submissions: 2,781,507


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1:
            return l2
        if not l2:
            return l1
        
        res = l1
        pre = None
        
        carry = 0
        while l1 and l2:
            l1.val = l1.val + l2.val + carry
            if l1.val >= 10:
                carry = 1
                l1.val -= 10
            else:
                carry = 0
            pre = l1
            l1 = l1.next
            l2 = l2.next
        
        if l2:
            pre.next = l2
            l1 = l2
        
        while l1:
            l1.val += carry
            if l1.val >= 10:
                carry = 1
                l1.val -= 10
            else:
                carry = 0
            pre = l1
            l1 = l1.next
        
        if carry == 1:
            pre.next = ListNode(1)
        
        return res
        