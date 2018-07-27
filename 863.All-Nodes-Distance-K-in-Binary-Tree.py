# https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
#
# algorithms
# Medium (40.3%)
# Total Accepted:    4.8K
# Total Submissions: 11.8K
# beats 83.46% of python submissions

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def distanceK(self, root, target, K):
        """
        :type root: TreeNode
        :type target: TreeNode
        :type K: int
        :rtype: List[int]
        """
        def resursive_as_root(root, K):
            """
            作为根结点遍历子节点，获取离自己K距离的子节点
            """
            if not root:
                return
            if K == 0:
                res[0] += root.val,
                return
            resursive_as_root(root.left, K - 1)
            resursive_as_root(root.right, K - 1)

        def add_parent(node):
            """
            遍历tree，寻找target，并为路径上的节点赋予parent数值
            元组中0，1分别代表是左，右子树，到时候遍历的时候取另外一边
            """
            if res[1]:
                return
            if node == target:
                res[1] = True
                return
            if node.left:
                node.left.parent = (node, 0)
                add_parent(node.left)
            if node.right:
                node.right.parent = (node, 1)
                add_parent(node.right)

        res = [[], False]
        resursive_as_root(target, K)
        add_parent(root)

        while target != root:
            parent, is_right_child = target.parent
            K -= 1
            if K == 0:
                res[0] += parent.val,
                break
            next_node = parent.left if is_right_child else parent.right
            resursive_as_root(next_node, K - 1)
            target = parent

        return res[0]
