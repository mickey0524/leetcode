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


# 复习的时候的优化版本
# 左节点的高度是没有必要计算的，只需要计算第一次

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution1(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = 0
        l_h, r_h = None, None

        while root:
            if l_h:
                l_h = l_h - 1
                r_h = self.get_tree_height(root.right)
            else:
                l_h, r_h = self.get_tree_height(
                    root.left), self.get_tree_height(root.right)

            res += 1 << r_h
            if l_h == r_h:
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

        
