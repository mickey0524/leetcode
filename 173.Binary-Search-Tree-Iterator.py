# https://leetcode.com/problems/binary-search-tree-iterator/
#
# algorithms
# Medium (49.5%)
# Total Accepted:    215,089
# Total Submissions: 434,545


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque


class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = deque()
        self.push(root)

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        top = self.stack.pop()
        self.push(top.right)

        return top.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return bool(self.stack)

    def push(self, root):
        while root:
            self.stack.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
