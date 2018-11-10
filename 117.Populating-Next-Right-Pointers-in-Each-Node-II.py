# https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
#
# algorithms
# Medium (33.42%)
# Total Accepted:    155.3k
# Total Submissions: 464.7k
# beats 70.02% of python submissions

# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

from collections import deque


class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if not root:
            return

        queue = deque([root, '#'])

        while True:
            ele = queue.popleft()
            if ele != '#':
                if queue[0] != '#':
                    ele.next = queue[0]
                if ele.left:
                    queue.append(ele.left)
                if ele.right:
                    queue.append(ele.right)
            else:
                if queue:
                    queue.append('#')
                else:
                    break

        return

