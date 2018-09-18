# https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
#
# algorithms
# Easy (61.31%)
# Total Accepted:    8.4k
# Total Submissions: 13.7k
# beats 14.19% of python submissions


"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = [[]]

        def resursive(node):
            if not node:
                return

            for child in node.children:
                resursive(child)

            res[0] += node.val,

        resursive(root)

        return res[0]
