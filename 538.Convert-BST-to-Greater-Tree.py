# https://leetcode.com/problems/convert-bst-to-greater-tree/
#
# algorithms
# Easy (51.97%)
# Total Accepted:    88,918
# Total Submissions: 171,108
# beats 100.0% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        acc = [0]

        def recursive(node):
            if not node:
                return

            recursive(node.right)

            node.val += acc[0]
            acc[0] = node.val

            recursive(node.left)

        recursive(root)

        return root
