# https://leetcode.com/problems/most-frequent-subtree-sum/
#
# algorithms
# Medium (53.42%)
# Total Accepted:    42,508
# Total Submissions: 79,579
# beats 96.83% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import defaultdict

class Solution(object):
    def findFrequentTreeSum(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []

        hash_map = defaultdict(int)

        def resursive(node):
            if not node.left and not node.right:
                hash_map[node.val] += 1
                return node.val

            res = node.val

            if node.left:
                res += resursive(node.left)
            if node.right:
                res += resursive(node.right)

            hash_map[res] += 1

            return res

        resursive(root)

        res = []
        max_s = float('-inf')
        for k, v in hash_map.iteritems():
            if v > max_s:
                res = [k]
                max_s = v
            elif v == max_s:
                res += k,
        
        return res