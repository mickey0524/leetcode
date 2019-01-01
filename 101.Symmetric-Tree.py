# https://leetcode.com/problems/symmetric-tree/
#
# algorithms
# Easy (42.17%)
# Total Accepted:    331,989
# Total Submissions: 788,072

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        return self._is_equal(root.left, root.right)
    
    def _is_equal(self, a, b):
        if not a and not b:
            return True
        elif not a or not b:
            return False
        elif a.val != b.val:
            return False
        
        return self._is_equal(a.left, b.right) and \
            self._is_equal(a.right, b.left)
            
        
        