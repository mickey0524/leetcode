# https://leetcode.com/problems/binary-tree-coloring-game/
# Medium (44.5%)
# Total Accepted:    3,170
# Total Submissions: 7,124
# beats 100.0 % of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def btreeGameWinningMove(self, root, n, x):
        """
        :type root: TreeNode
        :type n: int
        :type x: int
        :rtype: bool
        """
        point_num = [0, 0, 0]
        target_node = [None]

        def recursive(node):
            if not node or target_node[0]:
                return

            if node.val == x:
                target_node[0] = node
                return

            recursive(node.left)
            recursive(node.right)

        recursive(root)

        def count_node(node, idx):
            if not node:
                return

            point_num[idx] += 1

            count_node(node.left, idx)
            count_node(node.right, idx)

        count_node(target_node[0].left, 1)
        count_node(target_node[0].right, 2)
        point_num[0] = n - 1 - point_num[1] - point_num[2]

        if point_num[0] > point_num[1] + point_num[2] + 1:
            return True

        if point_num[1] > point_num[0] + point_num[2] + 1:
            return True

        if point_num[2] > point_num[1] + point_num[0] + 1:
            return True

        return False
