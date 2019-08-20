# https://leetcode.com/problems/binary-tree-level-order-traversal/
#
# algorithms
# Medium (49.68%)
# Total Accepted:    416,561
# Total Submissions: 838,257
# beats 100.0% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        if not root:
            return res
        
        q = deque([root, None])
        layer = []
        
        while True:
            cur = q.popleft()
            if not cur:
                res.append(layer)
                if not q:
                    break
                    
                layer = []
                q.append(None)
            
            else:
                layer.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
        
        return res

        