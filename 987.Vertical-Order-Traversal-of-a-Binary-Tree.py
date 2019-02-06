# https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
# Medium (33.12%)
# Total Accepted:    2,601
# Total Submissions: 7,853
# beats 100.0% of python submissions

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import defaultdict
from bisect import insort

class Solution(object):
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        hash_map = defaultdict(list)

        def recursive(node, x, y):
            if not node:
                return

            insort(hash_map[x], (y, node.val))

            recursive(node.left, x - 1, y + 1)
            recursive(node.right, x + 1, y + 1)

        recursive(root, 0, 0)

        res = []
        for x in sorted(hash_map.keys()):
            tmp = []
            for _, v in hash_map[x]:
                tmp += v,
            res += tmp,

        return res
