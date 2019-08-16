# https://leetcode.com/problems/diameter-of-binary-tree/
#
# algorithms
# Easy (47.28%)
# Total Accepted:    148,789
# Total Submissions: 314,710
# beats 100.0% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [1]

        def recursive(root):
            if not root:
                return 0

            l, r = recursive(root.left), recursive(root.right)
            res[0] = max(res[0], l + r + 1)

            return max(l, r) + 1

        recursive(root)

        return res[0] - 1
