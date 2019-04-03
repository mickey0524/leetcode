# https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
#
# algorithms
# Hard (39.96%)
# Total Accepted:    169,471
# Total Submissions: 424,062


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''

        res = ''
        q = deque([(root, 0)])
        while len(q) > 0:
            cur_node, cur_idx = q.popleft()
            res += str(cur_idx) + ':' + str(cur_node.val) + ','
            if cur_node.left:
                q.append((cur_node.left, cur_idx * 2 + 1))
            if cur_node.right:
                q.append((cur_node.right, cur_idx * 2 + 2))

        return res[:-1]

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == '':
            return None

        arr = data.split(',')
        idx, val = arr[0].split(':')
        root = TreeNode(val)
        hash_map = {0: root}

        for i in xrange(1, len(arr)):
            cur_idx, cur_val = arr[i].split(':')
            cur_idx = int(cur_idx)
            cur_node = TreeNode(cur_val)
            hash_map[cur_idx] = cur_node
            parent_idx = (cur_idx - 1) / 2
            if parent_idx * 2 + 1 == cur_idx:
                hash_map[parent_idx].left = cur_node
            else:
                hash_map[parent_idx].right = cur_node

        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
