# https://leetcode.com/problems/merge-k-sorted-lists/description/
#
# algorithms
# Hard (30.57%)
# Total Accepted:    279.6K
# Total Submissions: 914.6K
# beats 53.07% of python submissions
# 这道题把所有的val存起来排序，重新创建链表肯定最快，下面是不重新开辟空间的做法


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        length = len(lists)

        if length == 0:
            return None

        if length == 1:
            return lists[0]

        return self.mergeTwoList(self.mergeKLists(lists[length / 2:]), self.mergeKLists(lists[:length / 2]))

    def mergeTwoList(self, a, b):
        res = ListNode(0)
        res.next = a
        pre = res

        while a and b:
            while b and b.val <= a.val:
                pre.next = b
                tmp = b.next
                b.next = a
                pre = b
                b = tmp
            pre = a
            a = a.next

        if b:
            pre.next = b

        return res.next


from heapq import heappush, heappop


class Solution1(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []
        res = ListNode(-1)
        tmp = res

        for l in lists:
            if l:
                heappush(heap, (l.val, l))

        while heap:
            _, l = heappop(heap)
            if l.next:
                heappush(heap, (l.next.val, l.next))
            tmp.next = l
            tmp = l
            l.next = None

        return res.next
