# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
#
# algorithms
# Medium (37.86%)
# Total Accepted:    288,760
# Total Submissions: 762,780

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if p == root or q == root:
            return root
        
        res = [None]
        
        def recursive(node):
            if not node or res[0] is not None:
                return 0
            
            tmp = recursive(node.left) + recursive(node.right)
            
            if node == p or node == q:
                tmp += 1
            
            if tmp == 2:
                res[0] = node
                return 0
            
            return tmp
        
        recursive(root)
        
        return res[0]