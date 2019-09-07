# https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
#
# algorithms
# Easy (59.56%)
# Total Accepted:    8.1k
# Total Submissions: 13.6k
# beats 97.77% of python submissions


"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = [[]]

        def resursive(node):
            if not node:
                return
            res[0] += node.val,
            for child in node.children:
                resursive(child)

        resursive(root)

        return res[0]


from collections import deque


class Solution1(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []

        q = deque([root])
        res = []

        while q:
            node = q.pop()
            res.append(node.val)

            if node.children:
                for n in reversed(node.children):
                    q.append(n)

        return res
