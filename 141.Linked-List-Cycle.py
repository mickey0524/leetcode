# https://leetcode.com/problems/linked-list-cycle/
#
# algorithms
# Easy (34.90%)
# Total Accepted:    335,990
# Total Submissions: 962,680

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return False
        
        one_step, two_step = head.next, head.next.next
        
        while two_step:
            if two_step == one_step:
                return True
            one_step = one_step.next
            two_step = two_step.next
            if not two_step:
                return False
            two_step = two_step.next
            
        return False
        