# https://leetcode.com/problems/kth-smallest-element-in-a-bst/
#
# algorithms
# Medium (49.79%)
# Total Accepted:    199,308
# Total Submissions: 400,327
# beats 100.0% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.k = k
        self.res = None

        self.recursive(root)

        return self.res

    def recursive(self, node):
        if not node or self.res:
            return

        self.recursive(node.left)

        self.k -= 1
        if self.k == 0:
            self.res = node.val
            return

        self.recursive(node.right)
