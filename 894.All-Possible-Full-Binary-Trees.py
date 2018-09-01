# https://leetcode.com/problems/all-possible-full-binary-trees/description/
#
# algorithms
# Medium (64.1%)
# Total Accepted:    3k
# Total Submissions: 4.7k
# beats 87.00% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def allPossibleFBT(self, N):
        """
        :type N: int
        :rtype: List[TreeNode]
        """
        if N & 1 == 0:
            return []

        if N == 1:
            return [TreeNode(0)]

        res = []
        for i in xrange(1, N / 2 + 1, 2):
            left_arr = self.allPossibleFBT(i)
            right_arr = self.allPossibleFBT(N - 1 - i)
            for left in left_arr:
                for right in right_arr:
                    root = TreeNode(0)
                    root.left = left
                    root.right = right
                    res.append(root)
                    if i != N - i - 1:
                        root = TreeNode(0)
                        root.left = right
                        root.right = left
                        res.append(root)

        return res
