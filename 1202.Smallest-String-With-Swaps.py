# https://leetcode.com/problems/smallest-string-with-swaps/
# Medium (28.29%)
# Total Accepted:    1,313
# Total Submissions: 4,642
# beats 100.0 % of python submissions


from collections import defaultdict


class UnionFind(object):
    def __init__(self, N):
        """
        初始化参数
        type N: int 点的个数
        """
        self.count = N
        self.id = [i for i in xrange(N)]
        self.size = [1] * N

    def get_count(self):
        """
        获取并查集中不同种类的点
        rtype: int
        """
        return self.count

    def find(self, p):
        """
        查询id指代的节点的根节点
        type p: int 节点id
        rtype: int
        """
        if p != self.id[p]:
            self.id[p] = self.find(self.id[p])

        return self.id[p]

    def union(self, p, q):
        """
        在连通图中打通p节点和q节点
        type p: int 节点p
        type q: int 节点q
        """
        p_root, q_root = self.find(p), self.find(q)

        if p_root == q_root:
            return False

        if self.size[p_root] < self.size[q_root]:
            self.id[p_root] = q_root
            self.size[q_root] += self.size[p_root]
        else:
            self.id[q_root] = p_root
            self.size[p_root] += self.size[q_root]

        self.count -= 1

        return True


class Solution(object):
    def smallestStringWithSwaps(self, s, pairs):
        """
        :type s: str
        :type pairs: List[List[int]]
        :rtype: str
        """
        length = len(s)
        uf = UnionFind(length)

        for a, b in pairs:
            uf.union(a, b)

        hash_map = defaultdict(list)
        for idx, n in enumerate(uf.id):
            hash_map[uf.find(n)] += idx,

        res = list(s)
        for arr in hash_map.values():
            tmp = [res[i] for i in arr]
            tmp.sort()
            for idx, i in enumerate(arr):
                res[i] = tmp[idx]

        return ''.join(res)
