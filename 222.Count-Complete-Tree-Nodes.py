# https://leetcode.com/problems/count-complete-tree-nodes/description/
#
# algorithms
# Medium (29.38%)
# Total Accepted:    93.4k
# Total Submissions: 319k
# beats 74.52% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 这道题的思路是根据左右节点的高度来判断最后一个节点的位置

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        res = 0
        
        while root:
            left = self.get_tree_height(root.left)
            right = self.get_tree_height(root.right)
            res += 1 << right
            
            if left == right:
                root = root.right
            else:
                root = root.left
        
        return res
        
    def get_tree_height(self, root):
        height = 0
        while root:
            height += 1
            root = root.left
        
        return height
        