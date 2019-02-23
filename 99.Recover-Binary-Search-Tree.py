# https://leetcode.com/problems/recover-binary-search-tree/
#
# algorithms
# Easy (33.79%)
# Total Accepted:    110,511
# Total Submissions: 327,066
# beats 92.44% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        nodes = [None] * 4  # [first wrong, second wrong, last node, maybe wrong]

        def recursive(node):
            if not node:
                return

            recursive(node.left)
            if nodes[2] and nodes[2].val > node.val:
                if not nodes[0]:
                    nodes[0] = nodes[2]
                    nodes[3] = node
                else:
                    nodes[1] = node
            nodes[2] = node
            recursive(node.right)

        recursive(root)

        if not nodes[1]:
            nodes[1] = nodes[3]

        nodes[0].val, nodes[1].val = nodes[1].val, nodes[0].val
