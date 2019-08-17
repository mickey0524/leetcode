# https://leetcode.com/problems/path-sum-iii/
#
# algorithms
# Easy (43.45%)
# Total Accepted:    117,973
# Total Submissions: 271,533


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        res = [0]

        def recursive(node, pre_sum_list):
            if not node:
                return

            for idx, n in enumerate(pre_sum_list):
                tmp = n + node.val
                pre_sum_list[idx] = tmp
                if tmp == sum:
                    res[0] += 1

            if node.val == sum:
                res[0] += 1

            recursive(node.left, pre_sum_list + [node.val])
            recursive(node.right, pre_sum_list + [node.val])

        recursive(root, [])

        return res[0]
