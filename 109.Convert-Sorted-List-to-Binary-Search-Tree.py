# https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
#
# algorithms
# Medium (41.09%)
# Total Accepted:    178,624
# Total Submissions: 434,681
# beats 100.0% of python submissions

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        vals = []
        while head:
            vals += head.val,
            head = head.next

        return self.recursive(vals, 0, len(vals) - 1)

    def recursive(self, vals, first, last):
        if first > last:
            return None
        if first == last:
            return TreeNode(vals[first])

        middle = first + (last - first) / 2
        root = TreeNode(vals[middle])

        root.left = self.recursive(vals, first, middle - 1)
        root.right = self.recursive(vals, middle + 1, last)

        return root
