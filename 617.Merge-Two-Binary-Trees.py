# https://leetcode.com/problems/merge-two-binary-trees/
#
# algorithms
# Easy (69.13%)
# Total Accepted:    153,841
# Total Submissions: 222,336
# beats 99.00% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1 and not t2:
            return None

        if not t1 and t2:
            return t2

        if not t2 and t1:
            return t1

        t1.val += t2.val

        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)

        return t1
