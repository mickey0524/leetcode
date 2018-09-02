# https://leetcode.com/problems/increasing-order-search-tree/description/
#
# algorithms
# Easy (53.1%)
# Total Accepted:    2.4k
# Total Submissions: 4.5k

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def increasingBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        res = [[]]

        def resursive(node):
            if not node:
                return
            resursive(node.left)
            res[0].extend([node.val, None])
            resursive(node.right)

        resursive(root)

        return res[0][:-1]
