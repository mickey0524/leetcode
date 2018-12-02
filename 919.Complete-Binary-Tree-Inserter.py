# https://leetcode.com/problems/complete-binary-tree-inserter/
#
# algorithms
# Medium (53.97%)
# Total Accepted:    4,431
# Total Submissions: 8,210

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class CBTInserter(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.root = root
        i, arr = 0, [self.root]

        while i < len(arr):
            if arr[i].left:
                arr += arr[i].left,
            if arr[i].right:
                arr += arr[i].right,
            i += 1

        self.arr = arr

    def insert(self, v):
        """
        :type v: int
        :rtype: int
        """
        node = TreeNode(v)
        last_node_idx = len(self.arr) - 1
        self.arr += node,
        if (last_node_idx - 1) / 2 == last_node_idx / 2:
            self.arr[last_node_idx / 2].right = node
            return self.arr[last_node_idx / 2].val

        self.arr[last_node_idx / 2].left = node
        return self.arr[last_node_idx / 2].val

    def get_root(self):
        """
        :rtype: TreeNode
        """
        return self.root


# Your CBTInserter object will be instantiated and called as such:
# obj = CBTInserter(root)
# param_1 = obj.insert(v)
# param_2 = obj.get_root()
