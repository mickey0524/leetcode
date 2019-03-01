# https://leetcode.com/problems/palindrome-linked-list/
#
# algorithms
# Easy (35.29%)
# Total Accepted:    231,671
# Total Submissions: 656,459
# beats 100.0% of python submissions


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return True

        head_tmp = ListNode('#')
        head_tmp.next = head

        one, two, pre = head_tmp, head_tmp, None

        while two and two.next:
            two = two.next.next
            tmp = one.next
            one.next = pre
            pre = one
            one = tmp

        if two:
            l, r = one, one.next
            one.next = pre
        else:
            l, r = pre, one.next

        while r:
            if l.val != r.val:
                return False
            l, r = l.next, r.next

        return True
