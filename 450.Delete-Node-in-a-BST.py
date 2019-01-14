# https://leetcode.com/problems/delete-node-in-a-bst/
#
# algorithms
# Medium (38.78%)
# Total Accepted:    52,907
# Total Submissions: 136,417
# beats 93.27% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: TreeNode
        :type key: int
        :rtype: TreeNode
        """
        node = root
        parent = root
        while node and node.val != key:
            parent = node
            if node.val > key:
                node = node.left
            else:
                node = node.right

        if not node:
            return root

        def delete_node(node):
            if not node.left and not node.right:
                return None
            if not node.left:
                return node.right
            if not node.right:
                return node.left
            tmp = node.right
            while tmp.left:
                tmp = tmp.left
            tmp.left = node.left
            return node.right

        new_node = delete_node(node)

        if parent.val > key:
            parent.left = new_node
            return root
        if parent.val < key:
            parent.right = new_node
            return root

        return new_node
