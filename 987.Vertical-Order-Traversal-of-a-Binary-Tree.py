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


from collections import defaultdict, deque


class Solution1(object):
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []

        hash_map = defaultdict(list)
        q = deque([(root, 0, 0)])
        l, r = 0, 0

        while q:
            node, x, y = q.popleft()
            hash_map[x].append((y, node.val))
            l = min(l, x)
            r = max(r, x)

            if node.left:
                q.append((node.left, x - 1, y - 1))

            if node.right:
                q.append((node.right, x + 1, y - 1))

        res = []

        def compare(a, b):
            if a[0] == b[0]:
                return a[1] - b[1]

            return b[0] - a[0]

        for i in xrange(l, r + 1):
            if i in hash_map:
                hash_map[i].sort(cmp=compare)
                res.append([v[1] for v in hash_map[i]])

        return res
