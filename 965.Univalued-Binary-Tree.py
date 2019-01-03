# https://leetcode.com/problems/univalued-binary-tree/
# Easy (73.15%)
# Total Accepted:    6,213
# Total Submissions: 8,494
# beats 91.04% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.value = None
        
    def isUnivalTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        if self.value is None:
            self.value = root.val
        
        elif root.val != self.value:
            return False
        
        return self.isUnivalTree(root.left) and self.isUnivalTree(root.right)
    