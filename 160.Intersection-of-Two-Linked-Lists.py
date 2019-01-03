# https://leetcode.com/problems/intersection-of-two-linked-lists/
#
# algorithms
# Easy (31.19%)
# Total Accepted:    254,398
# Total Submissions: 815,597


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        tmp_a, tmp_b = headA, headB
        len_a, len_b = 0, 0

        while tmp_a:
            len_a += 1
            tmp_a = tmp_a.next

        while tmp_b:
            len_b += 1
            tmp_b = tmp_b.next

        if len_a == 0 or len_b == 0:
            return None

        if len_a > len_b:
            while len_a > len_b:
                headA = headA.next
                len_a -= 1
        elif len_b > len_a:
            while len_b > len_a:
                headB = headB.next
                len_b -= 1

        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None
