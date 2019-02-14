# https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
# Hard (53.09%)
# Total Accepted:    2,696
# Total Submissions: 5,078

# hash_map solution

from collections import defaultdict


class Solution(object):
    def countTriplets(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        hash_map = defaultdict(int)

        for m in A:
            for n in A:
                hash_map[m & n] += 1

        res = 0

        for n in A:
            for k, v in hash_map.iteritems():
                if n & k == 0:
                    res += v

        return res


# trie solution

class TrieNode(object):
    def __init__(self):
        self.zero = None
        self.one = None
        self.count = 0

    def add(self, n):
        cur_node = self

        for i in xrange(16):
            if n % 2 == 0:
                if cur_node.zero is None:
                    cur_node.zero = TrieNode()
                cur_node = cur_node.zero
            else:
                if cur_node.one is None:
                    cur_node.one = TrieNode()
                cur_node = cur_node.one
            n >>= 1

        cur_node.count += 1

    def sum_res(self, node, n, depth):
        if depth == 16:
            return node.count

        res = 0

        if node.zero is not None:
            res += self.sum_res(node.zero, n >> 1, depth + 1)

        if n % 2 == 0 and node.one is not None:
            res += self.sum_res(node.one, n >> 1, depth + 1)

        return res


class Solution1(object):
    def countTriplets(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        trie_root = TrieNode()

        for m in A:
            for n in A:
                trie_root.add(m & n)

        res = 0

        for n in A:
            res += trie_root.sum_res(trie_root, n, 0)

        return res
