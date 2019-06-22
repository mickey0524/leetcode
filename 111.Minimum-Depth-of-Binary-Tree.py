# https://leetcode.com/problems/minimum-depth-of-binary-tree/
#
# algorithms
# Easy (35.41%)
# Total Accepted:    300,329
# Total Submissions: 848,240
# beats 88.11% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        res = [float('inf')]

        def recursive(node, depth):
            if not node.left and not node.right:
                res[0] = min(res[0], depth + 1)
                return

            if depth >= res[0]:
                return

            if node.left:
                recursive(node.left, depth + 1)
            if node.right:
                recursive(node.right, depth + 1)

        recursive(root, 0)

        return res[0]
