# https://leetcode.com/problems/arithmetic-slices/
#
# algorithms
# Medium (48.29%)
# Total Accepted:    88,386
# Total Submissions: 183,034


from collections import defaultdict


class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        equations_map = {}
        hash_map = defaultdict(set)

        for idx, [a, b] in enumerate(equations):
            equations_map[(a, b)] = values[idx]
            hash_map[a].add(b)
            hash_map[b].add(a)

        query_len = len(queries)
        res = [-1.0] * query_len

        for i in xrange(query_len):
            a, b = queries[i]
            if a not in hash_map or b not in hash_map:
                continue

            if (a, b) in equations_map:
                res[i] = equations_map[(a, b)]

            elif (b, a) in equations_map:
                res[i] = 1 / equations_map[(b, a)]

            else:
                if a in hash_map:
                    is_visited = {a}
                    r = self.recursive(
                        hash_map, equations_map, a, b, is_visited)
                    if r != float('-inf'):
                        res[i] = r
                if res[i] == -1.0 and b in hash_map:
                    is_visited = {b}
                    r = self.recursive(
                        hash_map, equations_map, b, a, is_visited)
                    if r != float('-inf'):
                        res[i] = 1 / r

                if res[i] != -1.0:
                    equations_map[(a, b)] = res[i]
                    hash_map[a].add(b)
                    hash_map[b].add(a)

        return res

    def recursive(self, hash_map, equations_map, cur, target, is_visited):
        if target in hash_map[cur]:
            return equations_map[(cur, target)] if (cur, target) in equations_map else 1 / equations_map[(target, cur)]

        for t in hash_map[cur]:
            if t not in is_visited:
                v = equations_map[(cur, t)] if (
                    cur, t) in equations_map else 1 / equations_map[(t, cur)]
                return v * self.recursive(hash_map, equations_map, t, target, is_visited | {t})

        return float('-inf')
