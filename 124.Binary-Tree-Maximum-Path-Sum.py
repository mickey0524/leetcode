# https://leetcode.com/problems/binary-tree-maximum-path-sum/
#
# algorithms
# Hard (29.46%)
# Total Accepted:    177,254
# Total Submissions: 601,635

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [root.val]

        def recursive(node):
            if not node:
                return float('-inf')

            left, right = recursive(node.left), recursive(node.right)
            l, r = left + node.val, right + node.val
            a = l + r - node.val

            res[0] = max(res[0], left, right, l, r, node.val, a)

            return max(l, r, node.val)

        recursive(root)

        return res[0]
