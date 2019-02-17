# https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
#
# algorithms
# Medium (39.94%)
# Total Accepted:    26,874
# Total Submissions: 67,287
# beats 100.0% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque


class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        queue = deque([(root, 1)])
        res = 0

        while queue:
            l, r = queue[0][1], queue[-1][1]
            res = max(res, r - l + 1)
            for _ in xrange(len(queue)):
                cur_node, n = queue.popleft()
                if cur_node.left:
                    queue.append((cur_node.left, 2 * n))
                if cur_node.right:
                    queue.append((cur_node.right, 2 * n + 1))

        return res
