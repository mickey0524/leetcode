# https://leetcode.com/problems/range-sum-of-bst/description/
#
# algorithms
# Medium (84.21%)
# Total Accepted:    4.8k
# Total Submissions: 5.7k


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rangeSumBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: int
        """
        res = [0]

        def resursive(node):
            if not node:
                return

            resursive(node.left)
            if L <= node.val <= R:
                res[0] += node.val

            resursive(node.right)

        resursive(root)

        return res[0]
        