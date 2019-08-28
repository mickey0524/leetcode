# https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
#
# algorithms
# Medium (33.89%)
# Total Accepted:    196,418
# Total Submissions: 579,575


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head

        res = ListNode(-1)
        res.next = head
        tmp = res

        slow, fast = head, head.next

        while fast:
            if fast.val == slow.val:
                while fast and fast.val == slow.val:
                    fast = fast.next

                if not fast:
                    tmp.next = None
                    break

                tmp.next = fast

            else:
                tmp = tmp.next

            slow = fast
            fast = fast.next

        return res.next
