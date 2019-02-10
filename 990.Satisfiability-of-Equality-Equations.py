# https://leetcode.com/problems/satisfiability-of-equality-equations/
# Medium (33.11%)
# Total Accepted:    1,849
# Total Submissions: 5,758
# beats 100.0% of python submissions

from collections import defaultdict, deque


class Solution(object):
    def equationsPossible(self, equations):
        """
        :type equations: List[str]
        :rtype: bool
        """
        def default():
            return [[], []]
        hash_map = defaultdict(default)
        s = set()

        for e in equations:
            a, b, eq = e[0], e[-1], e[1:3]
            s |= {a, b}
            if a != b:
                if eq == '==':
                    hash_map[a][0] += b,
                    hash_map[b][0] += a,
                else:
                    hash_map[a][1] += b,
                    hash_map[b][1] += a,
            elif eq == '!=':
                return False

        flag = {}
        for k in s:
            flag[k] = 0

        value = 1
        for k, v in flag.iteritems():
            if v == 0:
                q = deque([k])
                while len(q) > 0:
                    cnt_k = q.popleft()
                    if flag[cnt_k] == 0:
                        flag[cnt_k] = value
                        value += 1
                    for kk in hash_map[cnt_k][0]:
                        if flag[kk] == 0:
                            flag[kk] = flag[cnt_k]
                            q.append(kk)
                        elif flag[kk] != flag[cnt_k]:
                            return False
                    for kk in hash_map[cnt_k][1]:
                        if flag[kk] == flag[cnt_k]:
                            return False

        return True
