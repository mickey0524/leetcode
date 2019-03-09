# https://leetcode.com/problems/house-robber-iii/
#
# algorithms
# Medium (47.38%)
# Total Accepted:    93,716
# Total Submissions: 197,795

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        return max(self.recursive(root))
        
    def recursive(self, node):
        if not node:
            return 0, 0
        
        l_pre, l_cur = self.recursive(node.left)
        r_pre, r_cur = self.recursive(node.right)
        
        pre = l_cur + r_cur
        cur = max(node.val + l_pre + r_pre, pre)
        
        return pre, cur
        
