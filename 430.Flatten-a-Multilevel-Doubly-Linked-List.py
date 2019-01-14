# https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
#
# algorithms
# Medium (39.13%)
# Total Accepted:    12,608
# Total Submissions: 32,218

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""
class Solution(object):
    def flatten(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return None
                
        tmp = head
        
        while tmp:
            if tmp.child:
                child_head = self.flatten(tmp.child)
                child_tail = child_head
                while child_tail.next:
                    child_tail = child_tail.next
                if tmp.next:
                    tmp.next.prev = child_tail
                    
                child_tail.next = tmp.next
                tmp.next = child_head
                child_head.prev = tmp
                tmp.child = None
                tmp = child_tail.next
            else:
                tmp = tmp.next
        
        return head