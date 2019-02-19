# https://leetcode.com/problems/serialize-and-deserialize-bst/
#
# algorithms
# Medium (45.59%)
# Total Accepted:    48,649
# Total Submissions: 106,690
# beats 86.97% of python submissions
# BST 只需要存 pre_order, 如果需要对任意 tree 还原，则需要存两个 order

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

import json

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        val_arr = [[]]

        def recursive(node):
            if not node:
                return

            val_arr[0] += node.val,
            recursive(node.left)
            recursive(node.right)

        recursive(root)

        pre_order = json.dumps(val_arr[0])

        return pre_order

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        pre_order = json.loads(data)

        def gen_tree(order):
            length = len(order)
            if length == 0:
                return None

            node = TreeNode(order[0])

            if length == 1:
                return node

            i = 0
            while i < length:
                if order[i] > order[0]:
                    break
                i += 1

            node.left = gen_tree(order[1:i])
            node.right = gen_tree(order[i:])

            return node

        return gen_tree(pre_order)

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
