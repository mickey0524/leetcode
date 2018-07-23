# https://leetcode.com/problems/leaf-similar-trees/description/
#
# algorithms
# Easy (65.2%)
# Total Accepted:    3.7k
# Total Submissions: 5.6k
# beats 100.0% of python submissions

# Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence
# For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
# wo binary trees are considered leaf-similar if their leaf value sequence is the same.
# Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        leaf_value = [[]]

        def resursive(node):
            if not node:
                return
            if not node.left and not node.right:
                leaf_value[0] += node.val,
                return
            resursive(node.left)
            resursive(node.right)

        resursive(root1)
        leaf_value_root1 = leaf_value[0][:]
        leaf_value[0] = []
        resursive(root2)

        return leaf_value_root1 == leaf_value[0]
