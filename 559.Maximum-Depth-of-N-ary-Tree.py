# https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
#
# algorithms
# Easy (41.9%)
# Total Accepted:    10k
# Total Submissions: 16.4k
# beats 61.0% of python submissions


"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """
        if not root:
            return 0

        if not root.children:
            return 1

        max_child_depth = float('-inf')

        for child in root.children:
            depth = self.maxDepth(child)
            if depth > max_child_depth:
                max_child_depth = depth

        return max_child_depth + 1
