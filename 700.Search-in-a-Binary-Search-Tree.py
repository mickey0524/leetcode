# https://leetcode.com/problems/search-in-a-binary-search-tree/description/
#
# algorithms
# Easy (61.59%)
# Total Accepted:    14.1k
# Total Submissions: 22.9k
# beats 40.59% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def searchBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        while root:
            if root.val == val:
                return root
            elif root.val < val:
                root = root.right
            else:
                root = root.left

        return None
