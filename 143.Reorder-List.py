# https://leetcode.com/problems/reorder-list/description/
#
# algorithms
# Medium (28.66%)
# Total Accepted:    131.3k
# Total Submissions: 458.1k

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 我的思路是双向链表
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        
        pre = None
        node = head
        
        while node:
            node.pre = pre
            pre = node
            node = node.next
            
        l, r = head, pre
        
        while l != r:
            next_r = r.pre
            if next_r == l:
                break
            r.next = l.next
            l.next = r
            l = r.next
            r = next_r
            r.next = None
        
        return
            
# 其实快慢指针来做相当方便
# 1. 将链表一分为二，用到快慢指针
# 2. 反转第二部分，反转链表是很重要的根基
# 3. 将两链表接起来

class Solution:
    def reorderList(self, head):
        """
        分三步走，
        第一步，将链表一分为二，用到快慢指针；
        第二步，反转第二部分，反转链表是很重要的根基；
        第三步，将两链表接起来。
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head:
            return 
        if not head.next:
            return 
        
        preslow = None
        slow = head
        fast = head
        while fast and fast.next:
            preslow = slow
            slow = slow.next
            fast = fast.next.next

        preslow.next = None

        left = head

        right = self.reverseList(slow)
        p1 = left
        p2 = right

        ans = ListNode(-1)
        p3 = ans
        while p1:
            # p3.next = p1
            # p3.next.next = p2
            # p1 = p1.next
            # p2 = p2.next
            # p3 = p3.next.next
            p3.next = p1
            temp = p1.next
            p3.next.next = p2
            p1 = temp
            p2 = p2.next
            p3 = p3.next.next

        if p2:
            p3.next = p2

        print ans
        

    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        node = head
        previous = None

        while node is not None:
            current = node.next
            node.next = previous
            previous = node
            node = current
        return previous