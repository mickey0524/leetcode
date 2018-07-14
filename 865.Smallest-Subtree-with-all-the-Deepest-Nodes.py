# https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
#
# algorithms
# Medium (47.4%)
# Total Accepted:    3.8K
# Total Submissions: 8K

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


from collections import deque


class Solution(object):
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        queue = deque()
        queue.append((root, 0))
        cnt_level, level = [], -1

        while len(queue) != 0:
            node, height = queue.popleft()
            if height > level:
                cnt_level = [node]
                level = height
            else:
                cnt_level += node,

            left, right = node.left, node.right
            if left:
                left.parent = node
                queue.append((left, height + 1))
            if right:
                right.parent = node
                queue.append((right, height + 1))

        level = set(cnt_level)

        while len(level) != 1:
            tmp = set()
            for node in level:
                tmp.add(node.parent)

            level = tmp.copy()

        return level.pop()
