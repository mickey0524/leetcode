# https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
#
# algorithms
# Easy (48.15%)
# Total Accepted:    222,749
# Total Submissions: 462,569

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        length = len(nums)
        
        if length == 0:
            return None
        
        if length == 1:
            return TreeNode(nums[0])
        
        middle = length / 2
        node = TreeNode(nums[middle])
        node.left = self.sortedArrayToBST(nums[:middle])
        node.right = self.sortedArrayToBST(nums[middle + 1:])
        
        return node