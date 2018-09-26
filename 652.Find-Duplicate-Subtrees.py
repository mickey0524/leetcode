# https://leetcode.com/problems/find-duplicate-subtrees/description/
#
# algorithms
# Easy (40.15%)
# Total Accepted:    22k
# Total Submissions: 54.8k
# beats 99.00% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        self.dic = {}
        self.res = []
        self.dfs(root)

        return self.res

    def dfs(self, node):
        if not node:
            return '#'

        tree_val = self.dfs(node.left) + self.dfs(node.right) + str(node.val)
        if tree_val in self.dic and self.dic[tree_val] == 1:
            self.res.append(node)
        self.dic[tree_val] = self.dic.get(tree_val, 0) + 1

        return tree_val
