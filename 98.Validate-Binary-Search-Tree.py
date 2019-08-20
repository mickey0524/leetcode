# https://leetcode.com/problems/validate-binary-search-tree/
#
# algorithms
# Medium (26.13%)
# Total Accepted:    448,754
# Total Submissions: 1,717,423


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        res = [True]
        
        def recursive(node, lower, upper):
            if not node or not res[0]:
                return
            
            if node.val <= lower or node.val >= upper:
                res[0] = False
                return
            
            recursive(node.left, lower, node.val)
            if res[0]:
                recursive(node.right, node.val, upper)
        
        recursive(root, float('-inf'), float('inf'))
        
        return res[0]
