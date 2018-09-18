# https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
#
# algorithms
# Easy (54.41%)
# Total Accepted:    7.4k
# Total Submissions: 13.6k
# beats 16.17% of python submissions


"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if not root:
            return []

        res, level = [], []
        nodes = [root, '#']
        i = 0

        while i < len(nodes):
            node = nodes[i]
            if node == '#':
                res.append(level)
                level = []
                if i == len(nodes) - 1:
                    break
                else:
                    nodes += '#',
            else:
                level += node.val,
                if node.children:
                    nodes.extend(node.children)
            i += 1

        return res
